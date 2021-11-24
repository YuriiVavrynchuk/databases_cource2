package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.AnimatorDTO;
import com.yvavrynchuk.domain.AnimatorEntity;
import org.springframework.stereotype.Component;

@Component
public class AnimatorMapper extends AbstractMapper<AnimatorEntity, AnimatorDTO> {

    @Override
    public AnimatorDTO mapObjectToDTO(AnimatorEntity animatorEntity) {
        if (animatorEntity == null) {
            return null;
        }

        AnimatorDTO.AnimatorDTOBuilder animatorDTOBuilder = AnimatorDTO.builder();
        animatorDTOBuilder.id(animatorEntity.getId());
        animatorDTOBuilder.name(animatorEntity.getName());
        animatorDTOBuilder.surname(animatorEntity.getSurname());
        animatorDTOBuilder.age(animatorEntity.getAge());
        animatorDTOBuilder.gender(animatorEntity.getGender());
        animatorDTOBuilder.character(animatorEntity.getCharacter());
        animatorDTOBuilder.salary(animatorEntity.getSalary());
        animatorDTOBuilder.experience(animatorEntity.getExperience());
        animatorDTOBuilder.phone(animatorEntity.getPhone());
        animatorDTOBuilder.email(animatorEntity.getEmail());

        return animatorDTOBuilder.build();
    }
}
