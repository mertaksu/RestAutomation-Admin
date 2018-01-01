package com.rest.automation.admin.da.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RESTAURANT_COMPANY")
public class CompanyDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPANY_ID")
	private Long companyId;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="ADDRESS")
	private String address;
	
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
	private List<PersonDomain> personList;

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public List<PersonDomain> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonDomain> personList) {
		this.personList = personList;
	}
	
}
