package com._520it._02_cascade;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

//销售单据明细
@Getter@Setter
public class SaleBillItem {
	private Long id;
	private String product;//销售的货品
	private BigDecimal number;//销售数量
	
	//多个单据明细属于同一个单据
	private SaleBill bill;
}
