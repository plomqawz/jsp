package com.controller;

public class Person {
	private String name;
	private int age;
	private String gender;
	private String[] hobby;
	private String job;
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender == null ? "" : gender.trim();
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job == null ? "" : job.trim();
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
