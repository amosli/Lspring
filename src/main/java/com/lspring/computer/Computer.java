package com.lspring.computer;

public class Computer {
	private Mainboard mainboard;

	public void startup() {
		mainboard.startup();
	}

	public void shutdown() {
		mainboard.shutdown();
	}

	public void setMainboard(Mainboard mainboard) {
		this.mainboard = mainboard;
	}

	public void do_work() {
		if (mainboard.havePower()) {
			System.out.println("开始工作！");
			for (int i = 0; i < 10; i++) {
				System.out.println("i=" + i);
			}
		} else
			throw new RuntimeException("没有电！");
	}
	public String getSetting(){
		return "主板："+mainboard.getName()+"价格："+mainboard.getPrice()+"内存是：...";
	}
	
	
	
}
