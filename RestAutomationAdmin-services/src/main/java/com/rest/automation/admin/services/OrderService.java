package com.rest.automation.admin.services;

import com.rest.automation.admin.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> listOfSelectedTablesActiveOrders(int tableId);

    List<OrderDto> allTablesActiveOrders();

    void cancelOrder(Long orderId) throws Exception;
}
