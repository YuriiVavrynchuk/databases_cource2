package com.yvavrynchuk.repository;

import com.yvavrynchuk.domain.ClientAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccountEntity, Integer> {
}
