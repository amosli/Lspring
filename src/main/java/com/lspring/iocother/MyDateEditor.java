package com.lspring.iocother;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateEditor extends PropertyEditorSupport {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("调用自定义的类型编辑器!");
		try {
			Date date = sdf.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		super.setAsText(text);
		
	}
	
}
