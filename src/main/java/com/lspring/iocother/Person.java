package com.lspring.iocother;

import java.util.Date;


public class Person {
	private String name;
	private Integer age = 25;
	private String tel;
	private Person parent;
	private Date bornDate;
	
	
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", tel=" + tel + ", parent=" + parent + "]";
	}
	public Person(String name) {
		super();
		this.name = name;
		System.out.println("创建Person,构造 函数1");
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Person(String name, Integer age) {
//		super();
//		this.name = name;
//		this.age = age;
//		System.out.println("创建Person,构造 函数2");
//	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
}
