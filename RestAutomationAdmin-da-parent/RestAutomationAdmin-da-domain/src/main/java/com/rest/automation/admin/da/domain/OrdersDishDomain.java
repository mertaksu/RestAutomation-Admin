package com.rest.automation.admin.da.domain;

import java.util.List;

import javax.persistence.*;

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
