package com.lspring.ioc;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ContainerImp implements Container {
	private Map<String, Object> beans = new HashMap<String, Object>();

	public ContainerImp() {
		// 初始化容器,把各个业务组件先进行初始化
		try {
			init();
			// injectBySetter();
			injectByField();
			// 依赖注入
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

	public Object getBean(String name) {
		return beans.get(name);
	}

	public <T> T getBean(Class<T> clz) {
		return null;
	}

	public void init() throws Exception {
		// 加载配置文件的内容,如果 是业务组件就创建实例,并保存到容器
		// 得类名，newInstance()
		// 放置到beans这个缓存
		Properties properties = new Properties();
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans.properties"));
		for (Object key : properties.keySet()) {
			if (key.toString().indexOf(".") < 0) {
				// properties.get(key);
				// 获得类名
				String clazz = properties.getProperty(key.toString());
				System.out.println("clazzName:" + clazz);
				// 创建 clazz指定bean实例
				Object bean = Class.forName(clazz).newInstance();
				beans.put(key.toString(), bean);
				System.out.println("bean:" + bean);
			}
		}

		// properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans.properties"));
		// String zwj = (String) properties.get("zwj");
		// Class clazz=Class.forName(zwj);
		// Boy boyzwjBoy=(Boy) clazz.newInstance();
	}

	public void injectBySetter() throws Exception {
		// 扫描配置文件，发起是属于依赖注入的配置，就执行依赖注入

		Properties properties = new Properties();
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans.properties"));
		for (Object o : properties.keySet()) {
			String key = o.toString();
			System.err.println("key:" + key);
			String value = properties.getProperty(key);
			if (key.indexOf(".") > 0) {
				// 获得类名 zwj.name=zhang wuji
				String beanName = key.substring(0, key.indexOf("."));
				System.out.println("beanName:" + beanName);
				String pname = key.substring(key.indexOf(".") + 1);
				// 获得beanName所对应的Bean
				Object bean = getBean(beanName);
				// 获得bean对象上的pname属性对应的setter方法 setName();
				Method method = null;
				// 获得所有属性
				PropertyDescriptor[] pds = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					System.err.println("pd.getName():" + pd.getName());
					if (pd.getName().equals(pname)) {
						method = pd.getWriteMethod();
						if (method != null) {
							// pvalue指定应该设置的属性的值
							Object pvalue = null;
							// 把配置文件中的内容转换成具体的属性值
							// 这里只支持String 与其它bean类型
							if (pd.getPropertyType() == String.class) {
								pvalue = value;
							} else {
								pvalue = getBean(value);
							}
							System.err.println("pvalue:" + pvalue);
							method.invoke(bean, pvalue);
						}
					}
				}

			}
		}

	}

	public void injectByField() throws Exception {
		// Properties properties = new Properties();
		// properties.load(ContainerImp.class.getResourceAsStream("beans.properties"));
//		beans.properties
		Properties properties = new Properties();
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans.properties"));

		for (Object object : properties.keySet()) {
			String key = object.toString();
			String value = properties.getProperty(key);
			if (key.indexOf(".") > 0) {
				String beanName = key.substring(0, key.indexOf(".") + 1);
				Object bean = getBean(beanName);
				String pname = key.substring(key.indexOf(".") + 1);
				Field[] declaredFields = bean.getClass().getDeclaredFields();
				for(Field f:declaredFields){
					System.err.println(f.getName());
				}
				Field field = bean.getClass().getDeclaredField(pname);
				PropertyDescriptor[] pds = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					Object pvalue = null;
					// 把配置文件中的内容转换成具体的属性值
					// 这里只支持String 与其它bean类型
					if (pd.getPropertyType() == String.class) {
						pvalue = value;
					} else {
						pvalue = getBean(value);
					}
					field.set(bean, pvalue);
				}

			}

		}
	}
}
