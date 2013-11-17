package com.lspring.springIoc;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private String name;
	private Integer age;
	private String parent;
	public String setParent(String parent){
		return this.parent = parent;
	}
	//到容器中找一个类型为String 的对象过来，注入进来
	@Autowired
	private  String Mytel;
	public String getName() {
		return name;
	}

	public Person() {
		super();
		System.out.println("初始化Person!");
	}
	
	public Person(String name) {
		super();
		System.out.println("初始化Person!传进来姓名参数！");
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	
	public Person(String name, Integer age) {
		super();
		System.out.println("构造子注入!___1");
		this.name = name;
		this.age = age;
	}
	public Person(Integer age,String name) {
		super();
		System.out.println("构造子注入!___2");
		this.name = name;
		this.age = age;
	}
	public Integer setAge(Integer age) {
		return this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person:[name=" + name + ",age=" + age +",Mytel="+Mytel+",parent="+parent+"]";
	}

}
