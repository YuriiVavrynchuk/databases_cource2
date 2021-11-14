package ua.lviv.iot.dao.impl;

import ua.lviv.iot.model.Order;

public class OrderDaoImpl extends AbstractDaoImpl<Order, String> {
    public OrderDaoImpl() {
        super(Order.class);
    }
}
