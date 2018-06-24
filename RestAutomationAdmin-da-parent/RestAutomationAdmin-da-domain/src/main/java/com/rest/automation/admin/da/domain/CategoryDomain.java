package com.rest.automation.admin.da.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID")
	private Long categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="CATEGORY_IMAGE")
	@Lob
	private byte[] image;
	
	@Column(name="STATUS")
	private boolean status;

}
