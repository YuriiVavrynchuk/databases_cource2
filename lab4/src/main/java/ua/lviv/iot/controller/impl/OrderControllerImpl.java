package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Order;
import ua.lviv.iot.service.impl.OrderServiceImpl;

public class OrderControllerImpl extends AbstractControllerImpl<Order, String> {
    public OrderControllerImpl() {
        super(new OrderServiceImpl());
    }
}
