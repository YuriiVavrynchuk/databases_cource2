package com.yvavrynchuk.service;

import com.yvavrynchuk.domain.BillEntity;
import com.yvavrynchuk.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillService extends AbstractService<BillEntity, Integer> {
    public BillRepository billRepository;

    @Override
    protected JpaRepository<BillEntity, Integer> getRepository() {
        return billRepository;
    }
}
