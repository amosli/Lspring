package com.lspring.iocother2;

import java.beans.Beans;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Springtest {
	
	public void datasource_test(){
		ApplicationContext acx = new ClassPathXmlApplicationContext("beans_datasource.xml");
		System.out.println("mydatasourceUrl:"+acx.getBean("dataSource"));
	
//		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//		ppc.setLocation(location);
	}

	public void factoryBean(){
		ApplicationContext acx = new ClassPathXmlApplicationContext("beans_factorybean.xml");
		Object bean = acx.getBean("myfactorybean");
		System.out.println("factoryBean:"+bean);
		System.out.println("factoryBeanClass:"+bean.getClass());
		
		Object bean2 = acx.getBean("myfactorybean");
		System.out.println("factoryBean2:"+bean2);
		System.out.println("factoryBeanClass2:"+bean2.getClass());
	}
	@Test
	public void namespace_shot_cut(){
		ApplicationContext acx = new ClassPathXmlApplicationContext("beans_short.xml");
		Object bean = acx.getBean("p1");
		System.out.println("factoryBean:"+bean);
		System.out.println(acx.getBean("p2"));
		System.out.println(acx.getBean("p3"));
		System.out.println(acx.getBean("p4"));

	}

	
}
