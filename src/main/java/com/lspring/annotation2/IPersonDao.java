package com.lspring.annotation2;

public interface IPersonDao {
	void savePerson(Person p);
	Person get(Long id);
}
