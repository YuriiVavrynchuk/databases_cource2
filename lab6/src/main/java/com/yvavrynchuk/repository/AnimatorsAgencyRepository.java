package com.yvavrynchuk.repository;

import com.yvavrynchuk.domain.AnimatorsAgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatorsAgencyRepository extends JpaRepository<AnimatorsAgencyEntity, Integer> {
}
