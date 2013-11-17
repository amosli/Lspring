package com.lspring.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Spring_Client {
	public static void main(String args[]){
		//创建资源，容器启动时候要加载资源文件里面的内容
		Resource resource = new ClassPathResource("beans.xml");
		//把spring的容器准备好 
		BeanFactory factory = new XmlBeanFactory(resource);
		//凡是找组件，均找spring容器要
		IHello helo = (IHello) factory.getBean("hello");
		helo.sayHi();
	}
}
