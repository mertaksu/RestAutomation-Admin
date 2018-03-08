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
@Table(name="TABLES")
public class TableDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TABLE_ID")
	private Integer tableId;
	
	@Column(name="TABLE_STATE")
	private String tableState;
	
	@Column(name="STATUS")
	private boolean status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="companyId")
	private CompanyDomain company;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableState() {
		return tableState;
	}

	public void setTableState(String tableState) {
		this.tableState = tableState;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
