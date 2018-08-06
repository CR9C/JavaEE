package com._520it._01_javabean;

public class User {
	private Long id = 12L;
	private String firstName;
	private String lastName;
	private Integer age;
	private boolean man;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	
	//设置全名,属性:fullName
	public void setFullName(String fullName) {
		
	}
	//为什么创建公共的无参数的构造器,方便反射创建对象
	public User() {
		
	}
	
}
