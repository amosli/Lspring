package com.lspring.aop;

import java.lang.reflect.Method;
import java.util.Date;

/** 
* @ClassName: WriteLogAspect 
* @Description:把解决日志及审核问题的代码均抽取一个切面 
* @author: amosli
* @email:amosli@infomorrow.com
* @date Nov 24, 2013 9:24:07 PM  
*/
public class WriteLogAspect {
	public void writeBeforeLog(Method method) {
		// 切面2：记录日志
		System.out.println(UserContext.getUser() + "准备调用"+method.getName()+"方法" + new Date());
	}

	public void writeAfterLog(Method method) {
		// 切面3：审计功能
		System.out.println(UserContext.getUser() + "成功调用"+method.getName()+"方法" + new Date());

	}
}
