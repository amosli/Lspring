package com.lspring.aop;

import org.junit.Test;

import com.lspring.aop.container.Container;
import com.lspring.aop.container.ContainerImp;

public class ClientTest {
	@Test
	public void test_dao(){
//		IPersonDao dao  = new PesonDaoImpl();
//		dao.save(new Person());
		
		Container c=new ContainerImp();
		IPersonDao dao=(IPersonDao) c.getBean("personDao");
		dao.save(new Person());
		System.out.println(dao.getClass());
	}
	
}
