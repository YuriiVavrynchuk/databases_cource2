package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.BillDTO;
import com.yvavrynchuk.domain.BillEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.BillMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/bills")
@RestController
@AllArgsConstructor
public class BillController extends AbstractController<BillEntity, BillDTO, Integer> {
    private BillService billService;
    private BillMapper billMapper;

    @Override
    protected AbstractService<BillEntity, Integer> getService() {
        return billService;
    }

    @Override
    protected AbstractMapper<BillEntity, BillDTO> getMapper() {
        return billMapper;
    }
}
