package com.lspring.aop;

import java.util.Date;

public class PesonDaoImplOld implements IPersonDao {

	public void save(Person person) {
		//切面2：记录日志
		System.out.println(UserContext.getUser()+"准备调用save()方法"+new Date());
		//切面1:安全性问题的代码
		if(!"admin".equals(UserContext.getUser())){
			new RuntimeException("没有权限！");
		}
		// 核心业务逻辑
		System.out.println("执行添加：insert into person ....");
		//切面3：审核功能
		System.out.println(UserContext.getUser()+"成功调用save()方法"+new Date());

	}

	public void update(Long id, Person person) {
		//切面2：记录日志
				System.out.println(UserContext.getUser()+"准备调用update()方法"+new Date());
		//切面1:安全性问题的代码
		if(!"admin".equals(UserContext.getUser())){
			new RuntimeException("没有权限！");
		}
		System.out.println("执行修改：update into peson......");
	}

	public void delete(Long id) {
		//切面2：记录日志
				System.out.println(UserContext.getUser()+"准备调用delete()方法"+new Date());
		//切面1:安全性问题的代码
		if(!"admin".equals(UserContext.getUser())){
			new RuntimeException("没有权限！");
		}
		System.out.println("执行删除：delete into peson......");

	}

}
