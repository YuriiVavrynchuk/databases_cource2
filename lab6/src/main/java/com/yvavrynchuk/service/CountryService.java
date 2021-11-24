package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.CountryEntity;
import com.yvavrynchuk.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService extends AbstractService<CountryEntity, Integer> {
    public CountryRepository countryRepository;

    @Override
    protected JpaRepository<CountryEntity, Integer> getRepository() {
        return countryRepository;
    }
}
