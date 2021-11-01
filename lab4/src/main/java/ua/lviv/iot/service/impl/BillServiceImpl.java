package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.BillDaoImpl;
import ua.lviv.iot.model.Bill;


public class BillServiceImpl extends AbstractServiceImpl<Bill, Integer> {
    public BillServiceImpl() { super(new BillDaoImpl()); }
}
