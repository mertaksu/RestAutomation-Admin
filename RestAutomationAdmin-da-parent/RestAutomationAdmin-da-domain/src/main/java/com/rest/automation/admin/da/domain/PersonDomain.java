package com.rest.automation.admin.da.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CompanyDomain getCompany() {
		return company;
	}

	public void setCompany(CompanyDomain company) {
		this.company = company;
	}

}
