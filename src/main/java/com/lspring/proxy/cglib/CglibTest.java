package com.lspring.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import com.lspring.proxy.jdk.ImpHello2;

public class CglibTest {
	@Test
	public void proxyClass(){
		//使用cglib的Enhancer来创建类的代理
		final ImpHello2 realObject= new ImpHello2();
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("准备执行:" + method.getName() + "--" + new Date());
				Object result = method.invoke(realObject, args);
				System.out.println("执行完成!");
				return result;
			}
		});
		//设置父类
		enhancer.setSuperclass(ImpHello2.class);
		//创建出类的代对象
		ImpHello2 hello = (ImpHello2) enhancer.create();
		//调用代理对象上的方法，均会去执行callback里面进行指定的invoke方法
		hello.sayHello();
		System.out.println(hello.getClass());
	}
}
