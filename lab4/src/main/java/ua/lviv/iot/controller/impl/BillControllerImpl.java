package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Bill;
import ua.lviv.iot.service.impl.BillServiceImpl;

public class BillControllerImpl extends AbstractControllerImpl<Bill, Integer> {
    public BillControllerImpl() {
        super(new BillServiceImpl());
    }
}
