package com.rest.automation.admin.da.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="DISHES")
@DynamicUpdate
public class DishDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="DISH_ID")
    private Long dishId;

    @Column(name="DISH_NAME")
    private String dishName;

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

    @ManyToOne
    @JoinColumn(name = "CAT_ID",nullable = false)
    private CategoryDomain categoryDomain;
}
