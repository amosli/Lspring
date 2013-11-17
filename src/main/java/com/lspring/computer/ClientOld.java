package com.lspring.computer;

public class ClientOld {
	public static void main(String args[]) {
		// 创建电脑
		Computer computer = new Computer();
		// 给电脑提供相应的配件（主板）
		Mainboard mainboard = new IntelBoard();
		computer.setMainboard(mainboard);
		computer.startup();
		//把主板集成到电脑上
		computer.do_work();
		computer.shutdown();
		System.out.println("电脑配置情况："+computer.getSetting());
	}

}
