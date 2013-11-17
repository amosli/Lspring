package com.lspring.computer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class ClientSpring {
	public static void main(String args[]) {
		// 准备配置文件资源
		FileSystemResource resource = new FileSystemResource("beans.xml");
		// 初始化Spring 容器
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		//通过容器找一个可以工作，组装完整的电脑（组件/bean）
		Computer computer = beanFactory.getBean(Computer.class);
		computer.startup();
		computer.do_work();
		computer.shutdown();
		System.out.println("电脑配置情况："+computer.getSetting());

		
	}
}
