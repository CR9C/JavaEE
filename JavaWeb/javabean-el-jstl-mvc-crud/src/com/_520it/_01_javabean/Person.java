package com._520it._01_javabean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="id")//排除id
public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	
	public static void main(String[] args) {
		System.out.println(new Person());
	}
}
