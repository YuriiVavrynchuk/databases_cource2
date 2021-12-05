package com.yvavrynchuk.repository;

import com.yvavrynchuk.domain.AnimatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatorRepository extends JpaRepository<AnimatorEntity, Integer> {
}
