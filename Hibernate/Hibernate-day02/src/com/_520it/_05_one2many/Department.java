package com._520it._05_one2many;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	//单向的one2many
	private List<Employee> emps = new ArrayList<>();

	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
