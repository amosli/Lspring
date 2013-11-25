package com.lspring.SpringAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* @ClassName: ClientTest 
* @Description: TODO
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 26, 2013 12:46:16 AM  
*/
public class ClientTest {

	public static void main(String[] args) {
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean_spring_aop.xml");
		IPersonDao dao = (IPersonDao) acx.getBean("personDao");
		dao.save(new Person());
	}

}
