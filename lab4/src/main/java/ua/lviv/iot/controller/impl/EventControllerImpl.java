package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Event;
import ua.lviv.iot.service.impl.EventServiceImpl;

public class EventControllerImpl extends AbstractControllerImpl<Event, String> {
    public EventControllerImpl() {
        super(new EventServiceImpl());
    }
}
