package com.rest.automation.admin.services.impl;

import com.rest.automation.admin.da.api.OrderApi;
import com.rest.automation.admin.dto.OrderDto;
import com.rest.automation.admin.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderApi orderApi;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        return orderApi.save(orderDto);
    }

    @Override
    public List<OrderDto> listOfSelectedTablesActiveOrders(int tableId) {
        return orderApi.tablesActiveOrders(tableId);
    }

    @Override
    public List<OrderDto> allTablesActiveOrders() {
        return orderApi.allActiveOrders();
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {
        orderApi.delete(orderId);
    }
}
