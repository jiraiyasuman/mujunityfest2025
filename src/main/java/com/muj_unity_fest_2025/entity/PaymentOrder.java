package com.muj_unity_fest_2025.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_order")
public class PaymentOrder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private  Integer orderId;
	@Column(name="team_name")
	private  String teamName;
	@Column(name="email")
	private String email;
	@Column(name="event_name")
	private String eventName;
	@Column(name="amount")
	private Double amount;
	@Column(name="order_status")
	private String orderStatus;
	@Column(name="razorpay_order_id")
	private String razorpayOrderId;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRazorPayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorPayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public PaymentOrder(Integer orderId, String teamName, String email, String eventName, Double amount,
			String orderStatus, String razorpayOrderId) {
		super();
		this.orderId = orderId;
		this.teamName = teamName;
		this.email = email;
		this.eventName = eventName;
		this.amount = amount;
		this.orderStatus = orderStatus;
		this.razorpayOrderId = razorpayOrderId;
	}
	public PaymentOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PaymentOrder [orderId=" + orderId + ", teamName=" + teamName + ", email=" + email + ", eventName="
				+ eventName + ", amount=" + amount + ", orderStatus=" + orderStatus + ", razorPayOrderId="
				+ razorpayOrderId + "]";
	}
	
}
