package com.muj_unity_fest_2025.mapper;

import com.muj_unity_fest_2025.dto.PaymentOrderDto;
import com.muj_unity_fest_2025.entity.PaymentOrder;

public class PaymentOrderMapper {

	public PaymentOrder mapToPaymenOrder(PaymentOrderDto paymentOrderDto) {
		PaymentOrder order = new PaymentOrder(
				paymentOrderDto.getOrderId(),
				paymentOrderDto.getTeamName(),
				paymentOrderDto.getEmail(),
				paymentOrderDto.getEventName(),
				paymentOrderDto.getAmount(),
				paymentOrderDto.getOrderStatus(),
				paymentOrderDto.getRazorPayOrderId()
				);
		return order;
	}
	
	public PaymentOrderDto mapToPaymentOrderDto(PaymentOrder paymentOrder) {
		PaymentOrderDto paymentOrderDto = new PaymentOrderDto(
				paymentOrder.getOrderId(),
				paymentOrder.getTeamName(),
				paymentOrder.getEmail(),
				paymentOrder.getEventName(),
				paymentOrder.getAmount(),
				paymentOrder.getOrderStatus(),
				paymentOrder.getRazorPayOrderId()
				);
		return paymentOrderDto;
	}
}
