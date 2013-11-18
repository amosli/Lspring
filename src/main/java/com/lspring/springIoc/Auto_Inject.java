package com.lspring.springIoc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Auto_Inject {
	@Test
	public void inject_basic(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_inject_auto.xml");
		System.out.println(applicationContext.getBean("p1"));
//		System.out.println(applicationContext.getBean("p21"));

	}
}
