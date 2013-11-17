package com.lspring.computer;

public class IntelBoard implements Mainboard {
	private boolean pwer;
	public String getName() {
		return "Intel board";
	}

	public String getPrice() {
		return "$3000";
	}

	public void startup() {
		pwer=true;
	}

	public void shutdown() {
		pwer=false;
	}

	public boolean havePower() {
		return pwer;
	}
	public void enhanceSpeed(){
		System.out.println("Speed Up!");
	}
	

}
