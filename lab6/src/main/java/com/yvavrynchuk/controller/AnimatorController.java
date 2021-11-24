package com.yvavrynchuk.controller;


import com.yvavrynchuk.DTO.AnimatorDTO;
import com.yvavrynchuk.domain.AnimatorEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.AnimatorMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.AnimatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/animators")
@RestController
@AllArgsConstructor
public class AnimatorController extends AbstractController<AnimatorEntity, AnimatorDTO, Integer> {
    private final AnimatorService animatorService;
    private final AnimatorMapper animatorMapper;

    @Override
    protected AbstractService<AnimatorEntity, Integer> getService() {
        return animatorService;
    }

    @Override
    protected AbstractMapper<AnimatorEntity, AnimatorDTO> getMapper() {
        return animatorMapper;
    }
}
