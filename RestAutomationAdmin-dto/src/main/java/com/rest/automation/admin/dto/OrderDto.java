package com.rest.automation.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Long orderId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date orderDate;

    private String description;

    private Double totalBill;

    private boolean status;

    private TableDto table;

    private List<DishDto> dishList;
}
