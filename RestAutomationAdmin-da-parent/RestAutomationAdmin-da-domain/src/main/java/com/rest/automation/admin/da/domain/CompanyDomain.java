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
	
    @OneToMany(fetch=FetchType.LAZY,mappedBy="company")
    private List<PersonDomain> personList;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="company")
    private List<TableDomain> tableList;
}
