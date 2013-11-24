package com.lspring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class JDKProxyObject implements InvocationHandler{
	private Object realObject;
	public Object CreateProxyObject(Object realObject){
		this.realObject = realObject;
		return  Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),realObject.getClass().getInterfaces(),this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 代理对象去调用真实对象的相应方法去响应
		System.out.println("准备执行:" + method.getName() + "--" + new Date());
		Object result = method.invoke(realObject, args);
		System.out.println("执行完成!");
		return result;
	}

}
