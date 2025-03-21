package com.muj_unity_fest_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOrderDto {

	private Integer orderId;
	private String teamName;
	private String email;
	private String eventName;
	private Double amount;
	private String orderStatus;
	private String razorPayOrderId;
	
}
