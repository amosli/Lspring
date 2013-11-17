package com.lspring.springIoc;

/** 
* @ClassName: PersonFactoryFamily 
* @Description: 动态工厂方法
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 6, 2013 12:48:24 AM  
*/
public class PersonFactoryFamily {
	
	private String family;
	
	
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public  Person createPerson(){
		System.out.println("通过静态工厂实例化bean!");
		return new Person(family+"");
	}
	
	public  Person createPerson(String name){
		System.out.println("通过静态工厂实例化bean!"+name);
		return new Person(family+":"+name);
	}
	
}
