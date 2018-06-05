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

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

@Getter
@Setter
@Entity
@Table(name="ORDER_DISHES")
@DynamicUpdate
public class OrdersDishDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ORDER_DISH_ID")
    private Long orderDishId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="orderId")
    private OrderDomain order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dishId")
    private DishDomain dish;
}
