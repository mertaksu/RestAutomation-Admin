package com.rest.automation.admin.da.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class CustomerDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private Long customerId;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="customer")
	private List<OrderDomain> orderList;
	
	@Column(name="GREETING_POINT")
	private String greetingPoint;

	@Column(name="GREETING_TEXT")
	private String greetingText;

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}

	public String getGreetingPoint() {
		return greetingPoint;
	}

	public void setGreetingPoint(String greetingPoint) {
		this.greetingPoint = greetingPoint;
	}

	public List<OrderDomain> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDomain> orderList) {
		this.orderList = orderList;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
