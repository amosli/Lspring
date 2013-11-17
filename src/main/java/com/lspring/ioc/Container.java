package com.lspring.ioc;

/** 
* @ClassName: Container 
* @Description: 通过窗口获得业务组件
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 4, 2013 12:30:46 AM  
*/
public interface Container {
	Object getBean(String name);
	//通过类型从容器中获得一个业务组件
	 <T> T getBean(Class<T> clz);
}
