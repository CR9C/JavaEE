package com._520it._01_many2one_one2many;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	
	//一个部门可以包含多个员工
	private List<Employee> employees = new ArrayList<>();

	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
