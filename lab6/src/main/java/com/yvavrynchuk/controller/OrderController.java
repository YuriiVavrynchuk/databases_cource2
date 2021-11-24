package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.OrderDTO;
import com.yvavrynchuk.domain.OrderEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.OrderMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/orders")
@RestController
@AllArgsConstructor
public class OrderController extends AbstractController<OrderEntity, OrderDTO, Integer> {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    protected AbstractService<OrderEntity, Integer> getService() {
        return orderService;
    }

    @Override
    protected AbstractMapper<OrderEntity, OrderDTO> getMapper() {
        return orderMapper;
    }
}
