package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.FeedbackDTO;
import com.yvavrynchuk.domain.FeedbackEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper extends AbstractMapper<FeedbackEntity, FeedbackDTO> {

    @Override
    public FeedbackDTO mapObjectToDTO(FeedbackEntity feedbackEntity) {
        if (feedbackEntity == null) {
            return null;
        }

        FeedbackDTO.FeedbackDTOBuilder feedbackDTOBuilder = FeedbackDTO.builder();
        feedbackDTOBuilder.client(feedbackEntity.getClient());
        feedbackDTOBuilder.date(feedbackEntity.getDate());
        feedbackDTOBuilder.text(feedbackEntity.getText());
        feedbackDTOBuilder.rate(feedbackEntity.getRate());
        feedbackDTOBuilder.eventId(feedbackEntity.getEventId());
        feedbackDTOBuilder.clientAccountId(feedbackEntity.getClientAccountId());

        return feedbackDTOBuilder.build();
    }
}
