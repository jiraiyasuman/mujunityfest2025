package com.muj_unity_fest_2025.serviceimpl;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.muj_unity_fest_2025.entity.PaymentOrder;
import com.muj_unity_fest_2025.repository.PaymentOrderRepository;
import com.muj_unity_fest_2025.service.PaymentOrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService{

	private PaymentOrderRepository paymentOrderRepository;
	@Value("${razorpay.key.id}")      // it is used to read the properties in the application.properties file i.e.; field injection
	private String razorpayKeyId;
	@Value("${razoray.secret.key}")
	private String razorPaySecret;
	
	private RazorpayClient razorpayClient;

	@Autowired
	public PaymentOrderServiceImpl(PaymentOrderRepository paymentOrderRepository) {
		super();
		this.paymentOrderRepository = paymentOrderRepository;
	}

	@Override
	public PaymentOrder createOrder(PaymentOrder paymentOrder) throws Exception {
		JSONObject orderReq = new JSONObject();
		orderReq.put("amount", paymentOrder.getAmount()*100);
		orderReq.put("currency", "INR");
		orderReq.put("receipt",paymentOrder.getEmail());
		this.razorpayClient = new RazorpayClient(razorpayKeyId, razorPaySecret);
		// create the order in razorpay 
		Order razorPayOrder = razorpayClient.orders.create(orderReq);
		System.out.println(razorPayOrder);
		paymentOrder.setRazorPayOrderId(razorPayOrder.get("id"));
		paymentOrder.setOrderStatus("PAYMENT_CREATED");
		paymentOrderRepository.save(paymentOrder);
		return paymentOrder;
	}

	@Override
	public PaymentOrder updateOrder(Map<String, String> responsePayLoad) {
		String razorPayOrId = responsePayLoad.get("razorpay_order_id");
		PaymentOrder paymentOrder = paymentOrderRepository.findByRazorpayOrderId(razorPayOrId);
		paymentOrder.setOrderStatus("PAYMENT_SUCCESSFUL");
		PaymentOrder updateOrder=paymentOrderRepository.save(paymentOrder);
		return updateOrder;
	}
	
	

}
