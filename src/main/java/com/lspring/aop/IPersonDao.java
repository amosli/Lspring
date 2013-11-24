package com.lspring.aop;

public interface IPersonDao {
	void save(Person person);
	
	void update(Long id,Person person);
	
	void delete(Long id);
	
	//...
	
}
