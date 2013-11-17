package com.lspring.ioc;

/**
 * @ClassName: Client
 * @Description: 使用了容器的客户端
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Nov 4, 2013 12:34:01 AM
 */
public class Client {
	public static void main(String args[]) {
		Container c = new ContainerImp();
		Girl girl = (Girl) c.getBean("sue");
		girl.kiss();
	}

}
