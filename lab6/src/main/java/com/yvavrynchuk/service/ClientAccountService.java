package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.ClientAccountEntity;
import com.yvavrynchuk.repository.ClientAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientAccountService extends AbstractService<ClientAccountEntity, Integer> {
    public ClientAccountRepository clientAccountRepository;

    @Override
    protected JpaRepository<ClientAccountEntity, Integer> getRepository() {
        return clientAccountRepository;
    }
}
