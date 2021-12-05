package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.EventDTO;
import com.yvavrynchuk.domain.EventEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.EventMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/events")
@RestController
@AllArgsConstructor
public class EventController extends AbstractController<EventEntity, EventDTO, Integer> {
    private final EventService eventService;
    private final EventMapper eventMapper;

    @Override
    protected AbstractService<EventEntity, Integer> getService() {
        return eventService;
    }

    @Override
    protected AbstractMapper<EventEntity, EventDTO> getMapper() {
        return eventMapper;
    }
}
