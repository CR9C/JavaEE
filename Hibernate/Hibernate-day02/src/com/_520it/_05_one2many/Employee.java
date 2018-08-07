package com._520it._05_one2many;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//在有关联关系中不要用@data,因为会提供toString,会自动打印出来,看不到延迟加载的效用了
//即使有toString也要排除掉关联关系dept
public class Employee {
	private Long id;
	private String name;
	private Department dept;//单向的many2one

	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
