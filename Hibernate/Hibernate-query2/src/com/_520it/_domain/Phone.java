package com._520it._domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Phone {
	private Long id;
	private PhoneType types;
	private String number;
	
	private Employee employee;//employee_id
}
