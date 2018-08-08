package com._520it._domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//部门
@Getter@Setter
public class Department {
	private Long id;
	private String name;
	private String sn;
	private Address address;

	private Employee manager;//manager_id
	
	private List<Employee> employees = new ArrayList<>();
}
