package com._520it._domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.compiler.ast.NewExpr;
import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class Employee {
	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hireDate;//type=date

	private Department dept;//dept_id
	
	
}
