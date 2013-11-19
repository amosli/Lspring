package com.lspring.annotation;

public interface IPersonService {
	boolean login(String name,String password);
	void addPerson(Person p);
}
