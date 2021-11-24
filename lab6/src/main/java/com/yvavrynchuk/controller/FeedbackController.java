package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.FeedbackDTO;
import com.yvavrynchuk.domain.FeedbackEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.FeedbackMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/feedbacks")
@RestController
@AllArgsConstructor
public class FeedbackController extends AbstractController<FeedbackEntity, FeedbackDTO, String> {
    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    @Override
    protected AbstractService<FeedbackEntity, String> getService() {
        return feedbackService;
    }

    @Override
    protected AbstractMapper<FeedbackEntity, FeedbackDTO> getMapper() {
        return feedbackMapper;
    }
}
