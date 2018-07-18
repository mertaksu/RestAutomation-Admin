package com.rest.automation.admin.rest.controller;

import com.rest.automation.admin.dto.OrderDto;
import com.rest.automation.admin.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrdersController {

    OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        OrderDto orderDto1 = null;
        try {
            orderDto1 = orderService.createOrder(orderDto);
        } catch (Exception e) {
            log.error("Exception occured while saving order.",e);
        }
        return orderDto1;
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getAllTablesActiveOrders() {
        List<OrderDto> orderDtoList = null;
        try {
            orderDtoList = orderService.allTablesActiveOrders();
        } catch (Exception e) {
            log.error("Exception occured while getting all active orders.",e);
        }
        return orderDtoList;
    }

    @RequestMapping(value = "/order/{tableId}",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getSelectedTablesActiveOrders(@PathVariable("tableId")int tableId) {
        List<OrderDto> orderDtoList = null;
        try {
            orderDtoList = orderService.listOfSelectedTablesActiveOrders(tableId);
        } catch (Exception e) {
            log.error("Exception occured while getting selected tables all active orders.",e);
        }
        return orderDtoList;
    }

    @RequestMapping(value = "/order/{orderId}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderService.cancelOrder(orderId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occured while deleting orders",e);
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
