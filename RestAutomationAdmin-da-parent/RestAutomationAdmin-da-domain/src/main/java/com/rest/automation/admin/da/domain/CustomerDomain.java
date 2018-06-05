package com.rest.automation.admin.da.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="CUSTOMERS")
public class CustomerDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private Long customerId;

	@Column(name="GREETING_POINT")
	private String greetingPoint;

	@Column(name="GREETING_TEXT")
	private String greetingText;
	
}
