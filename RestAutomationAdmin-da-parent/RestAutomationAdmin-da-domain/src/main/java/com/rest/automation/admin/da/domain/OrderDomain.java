package com.rest.automation.admin.da.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="ORDERS")
@DynamicUpdate
public class OrderDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TOTAL_BILL")
	private Double totalBill;
	
	@Column(name="STATUS")
	private boolean status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tableId")
	private TableDomain table;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customerId")
	private CustomerDomain customer;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="order")
	private List<FoodDomain> foods;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public TableDomain getTable() {
		return table;
	}

	public void setTable(TableDomain table) {
		this.table = table;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
