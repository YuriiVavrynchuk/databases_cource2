package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.OrderEntity;
import com.yvavrynchuk.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService extends AbstractService<OrderEntity, Integer> {
    public OrderRepository orderRepository;

    @Override
    protected JpaRepository<OrderEntity, Integer> getRepository() {
        return orderRepository;
    }
}
