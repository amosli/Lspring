package com.lspring.springIoc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Basic_Inject {
	@Test
	public void inject_basic(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/bean_inject.xml");
		System.out.println(applicationContext.getBean("p1"));
		System.err.println(applicationContext.getBean("p2"));
		System.out.println(applicationContext.getBean("p3"));

	
	}
}
