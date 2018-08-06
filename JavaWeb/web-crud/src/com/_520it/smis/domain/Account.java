package com._520it.smis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	private Long id;
	private String name;
	private Integer balance;
}