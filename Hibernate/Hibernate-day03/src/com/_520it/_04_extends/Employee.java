package com._520it._04_extends;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

//员工
@Setter
@Getter
public class Employee extends User {
	private BigDecimal salary;
}
