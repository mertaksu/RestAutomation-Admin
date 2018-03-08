package com.rest.automation.admin.da.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="FOODS")
@DynamicUpdate
public class FoodDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FOOD_ID")
	private Long foodId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	private CategoryDomain category;

	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<OrderDomain> order;
	
	@Column(name="FOOD_NAME")
	private String foodName;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="CALORIES")
	private Long calories;
	
	@Column(name="DISCOUNT")
	private Integer discount;
	
	@Column(name="AVG_COOKING_TIME")
	private Integer avgCookingTime;
	
	@Column(name="IMAGE")
	@Lob
	private byte[] image;
	
	@Column(name="STATUS")
	private boolean status;

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public CategoryDomain getCategoryId() {
		return category;
	}

	public void setCategoryId(CategoryDomain categoryId) {
		this.category = categoryId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getAvgCookingTime() {
		return avgCookingTime;
	}

	public void setAvgCookingTime(Integer avgCookingTime) {
		this.avgCookingTime = avgCookingTime;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
