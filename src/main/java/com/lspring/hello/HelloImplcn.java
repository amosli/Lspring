package com.lspring.hello;

/**
 * @ClassName: HelloImplcn
 * @Description: TODO
 * @author: amosli
 * @email:amosli@infomorrow.com
 * @date Oct 28, 2013 11:46:39 PM
 */
public class HelloImplcn implements IHello {
	private String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void sayHi() {
		System.out.println("内容长度："+msg.length());
		System.out.println("This is my first learn abuot Spring! 我想说："+msg);
	}

}
