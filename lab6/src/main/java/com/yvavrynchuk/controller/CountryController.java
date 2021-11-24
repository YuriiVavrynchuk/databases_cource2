package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.CountryDTO;
import com.yvavrynchuk.domain.CountryEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.CountryMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/countries")
@RestController
@AllArgsConstructor
public class CountryController extends AbstractController<CountryEntity, CountryDTO, Integer> {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @Override
    protected AbstractService<CountryEntity, Integer> getService() {
        return countryService;
    }

    @Override
    protected AbstractMapper<CountryEntity, CountryDTO> getMapper() {
        return countryMapper;
    }
}
