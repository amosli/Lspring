package com.lspring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import org.junit.Test;

/**
 * @ClassName: JdkProxyTest
 * @Description: 简单的JDK动态代理
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 24, 2013 6:05:49 PM
 */
public class JdkProxyTest {
	// 简单的JDK代理
	public void JdkTest() {
		// 如何创建实现 了某一个接口的代理对象??
		// 使用jdk的动态代理，可以随时创建出一个接口的代理对象
		Hello hello = (Hello) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[] { Hello.class }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("执行：" + method.getName());
				return "yes";
			}
		});
		// 当得出一个代理 对象以后，凡是调用代理对象上的非final的方法时，将会执行InvocationHandler对象中的invoke方法
		System.out.println("hello:" + hello.toString());
		System.out.println("hello_class:" + hello.getClass());
		System.out.println(hello == null);
		hello.sayHello();
	}
	public void proxy_test() {
		// 真实对象
		final Hello real_proxy = new ImpHello();
		// 代理对象
		Hello hello = (Hello) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[] { Hello.class }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 代理对象去调用真实对象的相应方法去响应
				System.out.println("准备执行:" + method.getName() + "--" + new Date());
				Object result = method.invoke(real_proxy, args);
				System.out.println("执行完成!");
				return result;
			}
		});
		hello.sayHello();
		hello.toString();
	}
	
	@Test
	public void proxyObject(){
		Hello hello = (Hello) new JDKProxyObject().CreateProxyObject(new ImpHello());
		hello.sayHello();
		//如果要创建一个类（没有实现接口）的代理，不能使用JDK动态代理
		ImpHello2 hello2 = (ImpHello2) new JDKProxyObject().CreateProxyObject(new ImpHello2());
		hello2.sayHello();
		
		
	}
}
