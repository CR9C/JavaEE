package com._520it._03_many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Student {
	private Long id;
	private String name;
	
//	private List<Teacher> teachers = new ArrayList<>();
	private Set<Teacher> teachers = new HashSet<>();
}
