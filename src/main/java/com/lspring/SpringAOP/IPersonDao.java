package com.lspring.SpringAOP;

public interface IPersonDao {
	void save(Person person);
	
	void update(Long id,Person person);
	
	void delete(Long id);
	
	//...
	
}
