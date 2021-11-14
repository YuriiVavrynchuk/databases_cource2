package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.OrderDaoImpl;
import ua.lviv.iot.model.Order;

public class OrderServiceImpl extends AbstractServiceImpl<Order, String> {
    public OrderServiceImpl() {
        super(new OrderDaoImpl());
    }
}
