package com.lspring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpirngTest {
//	@Test
	public void addPerson(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_annotation.xml");
		IPersonServiceImp serviceImp = applicationContext.getBean(IPersonServiceImp.class);
		serviceImp.addPerson(new Person());
	}
	
	
}
