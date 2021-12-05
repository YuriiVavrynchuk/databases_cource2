package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.EventEntity;
import com.yvavrynchuk.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService extends AbstractService<EventEntity, Integer> {
    public EventRepository eventRepository;

    @Override
    protected JpaRepository<EventEntity, Integer> getRepository() {
        return eventRepository;
    }
}
