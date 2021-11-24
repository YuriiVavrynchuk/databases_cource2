package com.yvavrynchuk.repository;

import com.yvavrynchuk.domain.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, String> {
}
