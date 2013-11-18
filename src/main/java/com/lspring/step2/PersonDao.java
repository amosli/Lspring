package com.lspring.step2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDao {
	@Test
	public void injectTest(){
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_step2.xml");
		System.out.println(applicationContext.getBean("person"));
		System.out.println(applicationContext.getBean("person_c"));
		Person person = (Person) applicationContext.getBean("person");
		//Spring 会把集合类型，初始化时统一使用某种类型
		System.out.println(person.getSchool().getClass());
		System.out.println("person_null:"+applicationContext.getBean("person_null"));
	}
	
}
