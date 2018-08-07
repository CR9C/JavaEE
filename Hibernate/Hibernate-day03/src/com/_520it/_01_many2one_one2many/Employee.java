package com._520it._01_many2one_one2many;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Long id;
	private String name;
	
	//多个员工对象属于同一个部门
	private Department dept;
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
