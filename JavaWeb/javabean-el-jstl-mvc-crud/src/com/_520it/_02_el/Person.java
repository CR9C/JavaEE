package com._520it._02_el;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Person {
	private String username = "Lucy";
	private Integer age = 18;
	private String[] hobbys = { "java", "c", "girl" };
	private List<String> list = Arrays.asList("list1", "list2", "list3");
	//给hashmap设置值,在声明的时候传进值
	private Map<String, Object> map = new HashMap<String,Object>() {
		{
			this.put("company", "小码哥教育");
			this.put("englishName", "see my go");
			this.put("www.xiaoma.com", "假域名");
		}
	};
}
