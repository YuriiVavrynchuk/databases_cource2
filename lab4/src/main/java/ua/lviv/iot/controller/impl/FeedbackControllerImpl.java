package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Feedback;
import ua.lviv.iot.service.impl.FeedbackServiceImpl;

public class FeedbackControllerImpl extends AbstractControllerImpl<Feedback, Integer> {
    public FeedbackControllerImpl() {
        super(new FeedbackServiceImpl());
    }
}
