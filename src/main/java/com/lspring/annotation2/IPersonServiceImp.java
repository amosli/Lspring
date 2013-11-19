package com.lspring.annotation2;


import javax.annotation.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Controller(value="personService")
@Scope("prototype")
public class IPersonServiceImp implements IPersonService {
//	@Autowired
	@Resource(name="personDao")
	private IPesonDaoImp dao;
	
	public IPersonServiceImp(){
		System.out.println("service ....init ......");
	}
	
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
