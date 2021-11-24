package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.AnimatorsAgencyEntity;
import com.yvavrynchuk.repository.AnimatorsAgencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimatorsAgencyService extends AbstractService<AnimatorsAgencyEntity, Integer> {
    public AnimatorsAgencyRepository animatorsAgencyRepository;

    @Override
    protected JpaRepository<AnimatorsAgencyEntity, Integer> getRepository() {
        return animatorsAgencyRepository;
    }
}
