package com.rest.automation.admin.da.api.impl;

import com.rest.automation.admin.da.api.OrderApi;
import com.rest.automation.admin.da.domain.DishDomain;
import com.rest.automation.admin.da.domain.OrderDomain;
import com.rest.automation.admin.da.domain.OrdersDishDomain;
import com.rest.automation.admin.da.mapper.impl.DishMapper;
import com.rest.automation.admin.da.mapper.impl.OrderMapper;
import com.rest.automation.admin.da.mapper.impl.TableMapper;
import com.rest.automation.admin.da.repository.OrderDishesRepository;
import com.rest.automation.admin.da.repository.OrderRepository;
import com.rest.automation.admin.dto.DishDto;
import com.rest.automation.admin.dto.OrderDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderApiImpl implements OrderApi {

    private OrderRepository orderRepository;

    private OrderDishesRepository orderDishesRepository;

    private OrderMapper orderMapper;

    private DishMapper dishMapper;

    private TableMapper tableMapper;

    public OrderApiImpl(OrderRepository orderRepository, OrderDishesRepository orderDishesRepository, OrderMapper orderMapper, DishMapper dishMapper, TableMapper tableMapper) {
        this.orderRepository = orderRepository;
        this.orderDishesRepository = orderDishesRepository;
        this.orderMapper = orderMapper;
        this.dishMapper = dishMapper;
        this.tableMapper = tableMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDto save(OrderDto orderDto) {
        OrderDto result = null;
        List<DishDto> dishDtoList = new ArrayList<>();
        OrderDomain savedOrder = orderRepository.save(orderMapper.dtoToDomain(orderDto));
        if (orderDto.getDishList() != null && orderDto.getDishList().size() > 0) {
            for (DishDto dishDto : orderDto.getDishList()) {
                OrdersDishDomain ordersDishDomain = new OrdersDishDomain();
                ordersDishDomain.setDish(dishMapper.dtoToDomain(dishDto));
                ordersDishDomain.setOrder(savedOrder);
                orderDishesRepository.save(ordersDishDomain);
            }
        }
        List<DishDomain> dishDomainList = orderDishesRepository.findOfOrdersDishes(savedOrder.getOrderId());
        for (DishDomain dishDomain : dishDomainList) {
            DishDto dto = dishMapper.domainToDto(dishDomain);
            dishDtoList.add(dto);
        }
        result = orderMapper.domainToDto(savedOrder);
        result.setDishList(dishDtoList);
        return result;
    }

    @Override
    public List<OrderDto> tablesActiveOrders(int tableId) {
        return orderDtoList(tableId);
    }

    @Override
    public List<OrderDto> allActiveOrders() {
        return orderDtoList(null);
    }

    @Transactional
    @Override
    public void delete(Long orderId) throws Exception {
        List<OrdersDishDomain> ordersDishDomains = orderDishesRepository.findAllByOrderDishId(orderId);
        orderDishesRepository.delete(ordersDishDomains);
        orderDishesRepository.flush();
        orderRepository.delete(orderId);
        orderRepository.flush();
    }

    private List<OrderDto> orderDtoList(Integer tableId) {
        List<OrderDto> activeTableList = new ArrayList<>();
        List<OrderDomain> orderDomainList = null;
        if(tableId!=null) {
            orderDomainList = orderRepository.findAllByStatusTrueAndTableTableId(tableId);
        } else {
            orderDomainList = orderRepository.findAllByStatusTrue();
        }
        if(orderDomainList != null && orderDomainList.size() > 0) {
            for (OrderDomain orderDomain : orderDomainList) {
                OrderDto orderDto = new OrderDto();
                orderDto.setDescription(orderDomain.getDescription());
                List<DishDomain> dishDomainList = orderDishesRepository.findOfOrdersDishes(orderDomain.getOrderId());
                if (dishDomainList!=null && dishDomainList.size() > 0) {
                    List<DishDto> dishDtoList = new ArrayList<>();
                    for (DishDomain dishDomain : dishDomainList) {
                        DishDto dishDto = dishMapper.domainToDto(dishDomain);
                        dishDtoList.add(dishDto);
                    }
                    orderDto.setDishList(dishDtoList);
                }
                orderDto.setOrderDate(orderDomain.getOrderDate());
                orderDto.setOrderId(orderDomain.getOrderId());
                orderDto.setStatus(orderDomain.getStatus());
                orderDto.setTable(tableMapper.domainToDto(orderDomain.getTable()));
                orderDto.setTotalBill(orderDomain.getTotalBill());
                activeTableList.add(orderDto);
            }
        }
        return  activeTableList;
    }
}
