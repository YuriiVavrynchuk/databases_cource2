package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.ClientAccountDTO;
import com.yvavrynchuk.domain.ClientAccountEntity;
import com.yvavrynchuk.mapper.AbstractMapper;
import com.yvavrynchuk.mapper.ClientAccountMapper;
import com.yvavrynchuk.service.AbstractService;
import com.yvavrynchuk.service.ClientAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/client_accounts")
@RestController
@AllArgsConstructor
public class ClientAccountController extends AbstractController<ClientAccountEntity, ClientAccountDTO, Integer> {
    private final ClientAccountService clientAccountService;
    private final ClientAccountMapper clientAccountMapper;

    @Override
    protected AbstractService<ClientAccountEntity, Integer> getService() {
        return clientAccountService;
    }

    @Override
    protected AbstractMapper<ClientAccountEntity, ClientAccountDTO> getMapper() {
        return clientAccountMapper;
    }
}
