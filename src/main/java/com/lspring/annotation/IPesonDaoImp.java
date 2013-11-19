package com.lspring.annotation;

public class IPesonDaoImp implements IPersonDao {

	public void savePerson(Person p) {
		System.out.println("执行数据库操作，保存person到数据库");
		System.out.println("insert into person values");
	}

	public Person get(Long id) {
		return null;
	}

}
