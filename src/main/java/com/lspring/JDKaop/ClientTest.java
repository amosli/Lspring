package com.lspring.JDKaop;

import org.junit.Test;

import com.lspring.JDKaop.container.Container;
import com.lspring.JDKaop.container.ContainerImp;

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
