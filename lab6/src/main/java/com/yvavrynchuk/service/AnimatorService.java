package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.AnimatorEntity;
import com.yvavrynchuk.repository.AnimatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimatorService extends AbstractService<AnimatorEntity, Integer>{
    public AnimatorRepository animatorRepository;

    @Override
    protected JpaRepository<AnimatorEntity, Integer> getRepository() {
        return animatorRepository;
    }
}
