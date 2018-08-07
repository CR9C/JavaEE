package com._520it._03_collection;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

//用户
@Setter
@Getter
public class User {
	private Long id;
	private String name;
	private Integer age;
	private Set<String> emailSet = new HashSet<>();//多个邮箱地址
	
}
