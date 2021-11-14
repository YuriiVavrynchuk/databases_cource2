package ua.lviv.iot.dao.impl;

import ua.lviv.iot.model.Event;

public class EventDaoImpl extends AbstractDaoImpl<Event, String> {
    public EventDaoImpl() {
        super(Event.class);
    }
}
