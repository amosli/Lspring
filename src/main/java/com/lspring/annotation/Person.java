package com.lspring.annotation;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class Person {
	private String name;
	private Integer age=25;
	private String tel;
	private Person parent;
	private String[] favs;
	private List<String> school ;
	private Set<String> cities;
	private Properties properties;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", tel=" + tel + ", parent=" + parent + ", favs=" + Arrays.toString(favs) + ", school=" + school + ", cities=" + cities + ", properties=" + properties + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
	public String[] getFavs() {
		return favs;
	}
	public void setFavs(String[] favs) {
		this.favs = favs;
	}
	public List<String> getSchool() {
		return school;
	}
	public void setSchool(List<String> school) {
		this.school = school;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
