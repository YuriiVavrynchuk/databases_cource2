package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.EventDTO;
import com.yvavrynchuk.domain.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper extends AbstractMapper<EventEntity, EventDTO> {

    @Override
    public EventDTO mapObjectToDTO(EventEntity eventEntity) {
        if (eventEntity == null) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTOBuilder = EventDTO.builder();
        eventDTOBuilder.id(eventEntity.getId());
        eventDTOBuilder.title(eventEntity.getTitle());
        eventDTOBuilder.subject(eventEntity.getSubject());
        eventDTOBuilder.guestsNumber(eventEntity.getGuestsNumber());
        eventDTOBuilder.address(eventEntity.getAddress());
        eventDTOBuilder.dateStart(eventEntity.getDateStart());
        eventDTOBuilder.dateEnd(eventEntity.getDateEnd());
        eventDTOBuilder.timeStart(eventEntity.getTimeStart());
        eventDTOBuilder.timeEnd(eventEntity.getTimeEnd());

        return eventDTOBuilder.build();
    }
}
