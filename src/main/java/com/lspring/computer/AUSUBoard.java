package com.lspring.computer;

public class AUSUBoard implements Mainboard {
	private boolean power;
	public String getName() {
		return "华硕主板!";


	}

	public String getPrice() {
		return "$1500";
	}

	public void startup() {
		power=true;
	}

	public void shutdown() {
	   power = false;
	}

	public boolean havePower() {
		return power;
	}

}
