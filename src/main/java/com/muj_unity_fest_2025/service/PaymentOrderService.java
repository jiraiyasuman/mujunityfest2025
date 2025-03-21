package com.muj_unity_fest_2025.service;

import java.util.Map;

import com.muj_unity_fest_2025.entity.PaymentOrder;

public interface PaymentOrderService {

	PaymentOrder createOrder(PaymentOrder paymentOrder)throws Exception;
	PaymentOrder updateOrder(Map<String,String> responsePayLoad);
}
