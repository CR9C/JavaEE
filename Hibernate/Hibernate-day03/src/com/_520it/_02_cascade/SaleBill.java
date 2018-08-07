package com._520it._02_cascade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//销售单据
@Getter@Setter
public class SaleBill {
	private Long id;
	private String sn;//单据编号
	private Date vdate;//业务时间
	
	//一个单据拥有多条明细
	private List<SaleBillItem> items = new ArrayList<>();
}
