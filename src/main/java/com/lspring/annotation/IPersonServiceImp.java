package com.lspring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class IPersonServiceImp implements IPersonService {
	@Autowired
	@Qualifier(value="persondao2")
	
//	@Resource(name="persondao2")
	private IPesonDaoImp dao;
	
	public boolean login(String name, String password) {
		return false;
	}
	
	public void addPerson(Person p) {
		//业务逻辑代码
		//根据条件判断唯一性
		dao.savePerson(p);
	}

	public IPesonDaoImp getDao() {
		return dao;
	}
//	@Autowired
	public void setDao(IPesonDaoImp dao) {
		System.out.println("setDao........");
		this.dao = dao;
	}

}
