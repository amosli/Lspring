package com.lspring.aop.container;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ContainerImp implements Container {
	private Map<String, Object> beans = new HashMap<String, Object>();

	public ContainerImp() {
		// 初始化容器,把各个业务组件先进行初始化
		try {
			init();
			injectBySetter();
			// injectByField();
			aop();
			// 依赖注入
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void aop() throws Exception {
		// 读到配置信息
		Properties properties = new Properties();
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("aop.properties"));
		for (Object item : properties.keySet()) {
			final String key = item.toString();
			// personDao.before=security.checkPermison,writelog.writeBeforeLog
			// key=personDao.before
			// value=security.checkPermison,writelog.writeBeforeLog
			System.err.println("key:" + key);
			String value = properties.getProperty(key);
			// 获得beanName
			String beanName = key.substring(0, key.indexOf("."));
			// 得到要创建代理的真实对象
			String values[] = value.split(",");
			for (final String vs : values) {
				// vs = security.checkPermison
				// 给bean创建一个代理
				// 检测bean有没有实现接口
				final Object bean = getBean(beanName);
				if (bean.getClass().getInterfaces().length > 0) {
					// 使用jdk动态代理来创建
					Object proxyBean = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							// 获得切面bean,及切面方法
							// vs = security.checkPermison
							String aspectBeanName = vs.substring(0, vs.indexOf("."));
							String aspectMethodName = vs.substring(vs.indexOf(".") + 1);
							Object aspectBean = getBean(aspectBeanName);
							// 找到一个public
							// 方法，而且只带一个Method类型参数，并且名称是aspectMethodName的方法
							Method aspectMethod = aspectBean.getClass().getMethod(aspectMethodName, Method.class);
							if (key.indexOf(".before") > 0) {
								// 执行切面上的aspectMethod方法
								aspectMethod.invoke(aspectBean, method);
							}
							// 1.先调用真实对象的方法
							Object result = method.invoke(bean, args);

							if (key.contains("after")) {
								aspectMethod.invoke(aspectBean, method);
							}

							return result;
						}
					});
					// 把代理bean保存到容器中
					beans.put(beanName, proxyBean);
				} else {
					// 使用其它的技术来创建代理
				}

			}
		}
		// personDao=com.lspring.aop.PesonDaoImpl
		// 得到容器中personDao的bean
		// 创建一个personDao的这个bean代理对象
		// InvocationHandler对象的invoke方法中：
		// 1.先调用真实对象的方法
		// 2.调用writeLogAspect这个切面的bean的writeAfeterLog方法
		// 3.返回return
		// 把代理对象返回存到容器中

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
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans_aop.properties"));
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
		properties.load(ContainerImp.class.getClassLoader().getResourceAsStream("beans_aop.properties"));
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
		// beans.properties
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
				for (Field f : declaredFields) {
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
