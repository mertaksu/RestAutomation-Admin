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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
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
	private Boolean status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tableId")
	private TableDomain table;

	@OneToMany(orphanRemoval = true,mappedBy = "order")
	private List<OrdersDishDomain> ordersDishDomains;
}
