package com.lspring.iocother2;

public class MyDataSource {
	private String driverClass;
	private String password;
	private String url;
	private String username;

	public String getDriverClass() {
		return driverClass;
	}

	@Override
	public String toString() {
		return "MyDataSource [driverClass=" + driverClass + ", password=" + password + ", url=" + url + ", username=" + username + "]";
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
