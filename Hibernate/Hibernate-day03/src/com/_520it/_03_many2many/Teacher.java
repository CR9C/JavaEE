package com._520it._03_many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Teacher {
	private Long id;
	private String name;
	
	private Set<Student> students = new HashSet<>();
}

