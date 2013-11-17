package com.lspring.ioc;

public class Girl {
	private String name;
	private Integer age;
	private Boy boy;
	public void kiss() {
		System.out.println("业务方法。。。。");
		System.out.println(name+"kiss with boy"+boy.getName());
	}
	public Girl(String name) {
		super();
		this.name = name;
	}
	public Girl() {
		super();
	}
//	public Girl(String name,  Boy boy) {
//		super();
//		this.name = name;
//		this.boy = boy;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boy getBoy() {
		return boy;
	}
	public void setBoy(Boy boy) {
		this.boy = boy;
	}
	


}
