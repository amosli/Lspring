package com.lspring.aop;


public class PesonDaoImpl implements IPersonDao {

	public void save(Person person) {
		// 核心业务逻辑
		System.out.println("执行添加：insert into person ....");

	}

	public void update(Long id, Person person) {
		System.out.println("执行修改：update into peson......");
	}

	public void delete(Long id) {
		System.out.println("执行删除：delete into peson......");
	}

}
