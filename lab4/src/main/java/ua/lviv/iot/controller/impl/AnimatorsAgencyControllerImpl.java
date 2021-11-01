package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.AnimatorsAgency;
import ua.lviv.iot.service.impl.AnimatorsAgencyServiceImpl;

public class AnimatorsAgencyControllerImpl extends AbstractControllerImpl<AnimatorsAgency, Integer> {
    public AnimatorsAgencyControllerImpl() {
        super(new AnimatorsAgencyServiceImpl());
    }
}
