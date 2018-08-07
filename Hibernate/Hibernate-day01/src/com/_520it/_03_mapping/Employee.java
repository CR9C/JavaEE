package com._520it._03_mapping;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
	private Long id;
	private String firstname;
	private String lastname;
	
	//LeBron#James
	private void setFullName(String fullName) {
		if (fullName != null) {
			String[] arr = fullName.split("#");
			if (arr.length == 2) {
				this.firstname = arr[0];
				this.lastname = arr[1];
			}
		}
	}
	
	private String getFullName() {
		return lastname +"#" +firstname;
	}
}
