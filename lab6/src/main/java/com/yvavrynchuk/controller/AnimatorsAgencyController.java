package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.AnimatorsAgencyDTO;
import com.yvavrynchuk.domain.AnimatorsAgencyEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.AnimatorsAgencyMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.AnimatorsAgencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/animators_agencies")
@RestController
@AllArgsConstructor
public class AnimatorsAgencyController extends AbstractController<AnimatorsAgencyEntity, AnimatorsAgencyDTO, Integer> {
    private final AnimatorsAgencyService animatorsAgencyService;
    private final AnimatorsAgencyMapper animatorsAgencyMapper;

    @Override
    protected AbstractService<AnimatorsAgencyEntity, Integer> getService() {
        return animatorsAgencyService;
    }

    @Override
    protected AbstractMapper<AnimatorsAgencyEntity, AnimatorsAgencyDTO> getMapper() {
        return animatorsAgencyMapper;
    }
}
