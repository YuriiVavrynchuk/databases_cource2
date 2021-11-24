package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.FeedbackEntity;
import com.yvavrynchuk.repository.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackService extends AbstractService<FeedbackEntity, String> {
    public FeedbackRepository feedbackRepository;

    @Override
    protected JpaRepository<FeedbackEntity, String> getRepository() {
        return feedbackRepository;
    }
}
