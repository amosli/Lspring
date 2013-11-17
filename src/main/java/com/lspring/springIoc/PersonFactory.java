package com.lspring.springIoc;

public class PersonFactory {
	public static Person createPerson(){
		System.out.println("通过静态工厂实例化bean!");
		return new Person();
	}
	
	public static Person createPerson(String name){
		System.out.println("通过静态工厂实例化bean!"+name);
		return new Person(name);
	}
	
}
