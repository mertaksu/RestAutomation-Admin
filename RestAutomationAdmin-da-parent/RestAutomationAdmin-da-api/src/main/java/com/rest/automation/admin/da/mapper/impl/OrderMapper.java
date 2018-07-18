package com.rest.automation.admin.da.mapper.impl;

import com.rest.automation.admin.da.domain.OrderDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements DomainDtoMapperInterface<OrderDomain,OrderDto> {

    @Autowired
    TableMapper tableMapper;

    @Override
    public OrderDomain dtoToDomain(OrderDto orderDto) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setDescription(orderDto.getDescription());
        orderDomain.setOrderDate(orderDto.getOrderDate());
        orderDomain.setOrderId(orderDto.getOrderId());
        orderDomain.setStatus(orderDto.isStatus());
        orderDomain.setTotalBill(orderDto.getTotalBill());
        orderDomain.setTable(tableMapper.dtoToDomain(orderDto.getTable()));
        return orderDomain;
    }

    @Override
    public OrderDto domainToDto(OrderDomain orderDomain) {
        OrderDto orderDto = new OrderDto();
        orderDto.setDescription(orderDomain.getDescription());
        orderDto.setOrderDate(orderDomain.getOrderDate());
        orderDto.setOrderId(orderDomain.getOrderId());
        orderDto.setStatus(orderDomain.getStatus());
        orderDto.setTotalBill(orderDomain.getTotalBill());
        orderDto.setTable(tableMapper.domainToDto(orderDomain.getTable()));
        return orderDto;
    }
}
