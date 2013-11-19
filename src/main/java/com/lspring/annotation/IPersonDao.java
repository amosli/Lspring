package com.lspring.annotation;

public interface IPersonDao {
	void savePerson(Person p);
	Person get(Long id);
}
