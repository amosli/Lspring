package com.lspring.iocother;

import java.beans.PropertyEditor;

import org.junit.Test;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_other.xml");
		Person person = (Person) applicationContext.getBean("p1");
		System.out.println(person);

		CustomEditorConfigurer ccConfigurer = new CustomEditorConfigurer();
	}
	
	
}
