package com.muj_unity_fest_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muj_unity_fest_2025.entity.PaymentOrder;
@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Integer>{
	PaymentOrder findByRazorpayOrderId(String razorPayOrderId);
}
