package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.OrderDto;

import java.util.List;

public interface OrderApi {
    OrderDto save(OrderDto orderDto);

    List<OrderDto> tablesActiveOrders(int tableId);

    List<OrderDto> allActiveOrders();

    void delete(Long orderId) throws Exception;
}
