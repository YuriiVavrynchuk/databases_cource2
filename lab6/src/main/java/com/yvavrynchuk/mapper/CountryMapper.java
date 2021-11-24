package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.CountryDTO;
import com.yvavrynchuk.domain.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper extends AbstractMapper<CountryEntity, CountryDTO> {

    @Override
    public CountryDTO mapObjectToDTO(CountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }

        CountryDTO.CountryDTOBuilder countryDTOBuilder = CountryDTO.builder();
        countryDTOBuilder.id(countryEntity.getId());
        countryDTOBuilder.country(countryEntity.getCountry());

        return countryDTOBuilder.build();
    }
}
