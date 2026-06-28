package com.aravind.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private Integer OrderId;
	private Integer id;
	private String type;
	private Double price;
	private Integer quantity;
}
