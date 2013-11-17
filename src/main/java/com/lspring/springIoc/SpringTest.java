package com.lspring.springIoc;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @ClassName: SpringTest
 * @Description: 学习Spring的API
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 5, 2013 12:58:39 AM
 */
public class SpringTest {

//	@Test
	public void beanName() {
		// 获取 bean的所有名称
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
		System.out.println(((ListableBeanFactory) factory).getBeanDefinitionNames());
		String[] names = ((ListableBeanFactory) factory).getBeanDefinitionNames();
		System.out.println("names:" + Arrays.toString(names));

		String[] aliases = factory.getAliases("p1");
		Object object = factory.getBean("p1");
		System.out.println("p1:" + object);
		// 获取bean的别名
		System.out.println("bean的别名:" + Arrays.toString(factory.getAliases("p3")));
		BeanDefinition bDefinition;
	}

	@Test
	public void createbean_family(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_create.xml");
		Person person = (Person) applicationContext.getBean("p5");
		System.out.println("person:"+person);
		Person person6 = (Person) applicationContext.getBean("p6");
		System.out.println("person6:"+person6);
	}
	
	public void createBean(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_create.xml");
		Person person =(Person) applicationContext.getBean("p4");
		System.out.println("person:"+person);
	}
	
	public void applicationContext() {
		//初始化一个 applicationContext容器
		//context依赖el表达式,expression
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean_create.xml");
//		System.out.println(applicationContext.getBean(Person.class));
	
	}
	
//	@Test
	public void xmlBeanfacotry() {
		BeanFactory  factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
//		System.out.println(factory.getBean("p1"));
	}
	
	

}
