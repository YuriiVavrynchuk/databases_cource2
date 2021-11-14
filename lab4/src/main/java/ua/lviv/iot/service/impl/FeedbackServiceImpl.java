package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.FeedbackDaoImpl;
import ua.lviv.iot.model.Feedback;

public class FeedbackServiceImpl extends AbstractServiceImpl<Feedback, Integer> {
    public FeedbackServiceImpl() {
        super(new FeedbackDaoImpl());
    }
}
