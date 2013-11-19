package com.lspring.step2;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
	private String name;
	private Integer age=25;
	private String tel;
	private Person parent;
	private String[] favs;
	private List<String> school;
	private Set<String> cities;
	private Properties properties;
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	private Map<String, Double> scores; 

	public Map<String, Double> getScores() {
		return scores;
	}

	public void setScores(Map<String, Double> scores) {
		this.scores = scores;
	}

	public Set<String> getCities() {
		return cities;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}

	public List<String> getSchool() {
		return school;
	}

	public void setSchool(List<String> school) {
		this.school = school;
	}

	public String[] getFavs() {
		return favs;
	}

	public void setFavs(String[] favs) {
		this.favs = favs;
	}

	private URL homePage;

	public URL getHomePage() {
		return homePage;
	}

	public void setHomePage(URL homePage) {
		this.homePage = homePage;
	}

	public String getName() {
		return name;
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
		System.out.println("初始化person!");
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", tel=" + tel + ", parent=" + parent + ", favs=" + Arrays.toString(favs) + ", school=" + school + ", cities=" + cities + ", properties=" + properties + ", scores=" + scores + ", homePage=" + homePage + "]";
	}
}
