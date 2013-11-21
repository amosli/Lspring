package com.lspring.iocother2;

import org.springframework.beans.factory.FactoryBean;

import com.lspring.springIoc.Person;

public class MyFactoryBean implements FactoryBean<Person> {
	//要产品的时候会调用Object方法
	public Person getObject() throws Exception {
		System.out.println("getObject");
		return new Person();
	}

	public Class<Person> getObjectType() {
		System.out.println("getObjectType!");
		return null;
	}

	public boolean isSingleton() {
		System.out.println("isSingleton");
		return true;
	}

}
