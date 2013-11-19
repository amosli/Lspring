package com.lspring.annotation2;

import org.springframework.stereotype.Repository;

@Repository(value="personDao")
public class IPesonDaoImp implements IPersonDao {
	
	
	public void savePerson(Person p) {
		System.out.println("执行数据库操作，保存person到数据库");
		System.out.println("insert into person values");
	}

	public Person get(Long id) {
		return null;
	}

}
