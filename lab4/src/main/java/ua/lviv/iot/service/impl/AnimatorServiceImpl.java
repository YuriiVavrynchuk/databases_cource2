package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.AnimatorDaoImpl;
import ua.lviv.iot.model.Animator;

public class AnimatorServiceImpl extends AbstractServiceImpl<Animator, Integer> {
    public AnimatorServiceImpl() {
        super(new AnimatorDaoImpl());
    }
}
