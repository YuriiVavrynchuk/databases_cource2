package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.AnimatorsAgencyDTO;
import com.yvavrynchuk.domain.AnimatorsAgencyEntity;
import org.springframework.stereotype.Component;

@Component
public class AnimatorsAgencyMapper extends AbstractMapper<AnimatorsAgencyEntity, AnimatorsAgencyDTO> {

    @Override
    public AnimatorsAgencyDTO mapObjectToDTO(AnimatorsAgencyEntity animatorsAgencyEntity) {
        if (animatorsAgencyEntity == null) {
            return null;
        }

        AnimatorsAgencyDTO.AnimatorsAgencyDTOBuilder animatorsAgencyDTOBuilder = AnimatorsAgencyDTO.builder();
        animatorsAgencyDTOBuilder.businessId(animatorsAgencyEntity.getBusinessId());
        animatorsAgencyDTOBuilder.name(animatorsAgencyEntity.getName());
        animatorsAgencyDTOBuilder.address(animatorsAgencyEntity.getAddress());
        animatorsAgencyDTOBuilder.workersNumber(animatorsAgencyEntity.getWorkersNumber());
        animatorsAgencyDTOBuilder.license(animatorsAgencyEntity.getLicense());
        animatorsAgencyDTOBuilder.bankAccount(animatorsAgencyEntity.getBankAccount());
        animatorsAgencyDTOBuilder.registrationCountry(animatorsAgencyEntity.getRegistrationCountry());

        return animatorsAgencyDTOBuilder.build();
    }
}
