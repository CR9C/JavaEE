package com._520it.shopping.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 商品对象
 */
@Data
public class Product {
	private Long id;
	private String productName;
	private String brand;//商标
	private String supplier;//供应商
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private Double cutoff;
	private Long dir_id;
}
