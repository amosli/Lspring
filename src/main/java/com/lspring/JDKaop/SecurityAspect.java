package com.lspring.JDKaop;

public class SecurityAspect {
	public void checkPermison() {
		// 切面1:安全性问题的代码
		System.out.println("执行权限检测！！");
		if (!"admin".equals(UserContext.getUser())) {
			throw new RuntimeException("没有权限！");
		}
	}
}
