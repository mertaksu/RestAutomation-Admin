package com.rest.automation.admin.da.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="PERSON")
@DynamicUpdate
public class PersonDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
	private CompanyDomain company;
	
    @Column(name="STATUS")
	private Boolean status;
	
    @Column(name="FULL_NAME")
	private String fullName;
	
    @Column(name="ROLE")
	private String role;
	
    @Column(name="USER_NAME")
	private String username;
	
    @Column(name="PASSWORD")
	private String password;

}
