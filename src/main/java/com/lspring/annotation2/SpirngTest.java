package com.lspring.annotation2;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lspring.annotation3.HelloImp;

public class SpirngTest {
	@Test
	public void addPerson_By_annotation2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_annotation_2.xml");
		IPersonServiceImp serviceImp = applicationContext.getBean(IPersonServiceImp.class);
		serviceImp.addPerson(new Person());
//		怎么查看配置中哪些bean？
		String[] names = applicationContext.getBeanDefinitionNames();
		System.out.println(Arrays.toString(names));
		System.out.println(applicationContext.getBean("personService"));
		System.out.println(applicationContext.getBean("personService"));
		System.out.println(serviceImp.getClass());
		System.out.println(serviceImp.getClass());
	
		System.err.println(applicationContext.getBean(HelloImp.class));
	}
	
	
	
}
