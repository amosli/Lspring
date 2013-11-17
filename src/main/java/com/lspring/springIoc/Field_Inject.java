package com.lspring.springIoc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Field_Inject {
	@Test
	public void inject_basic(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_inject_field.xml");
		System.out.println(applicationContext.getBean("p11"));
	}
}
