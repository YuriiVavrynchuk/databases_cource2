package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Animator;
import ua.lviv.iot.service.impl.AnimatorServiceImpl;

public class AnimatorControllerImpl extends AbstractControllerImpl<Animator, Integer> {
    public AnimatorControllerImpl() {
        super(new AnimatorServiceImpl());
    }
}
