package com._520it._domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Project {
	private Long id;
	private String name;
	
	private Employee manager;//manager_id
	
	//project_employees/employee_id/project_id
	private List<Employee> employees = new ArrayList<>();
}
