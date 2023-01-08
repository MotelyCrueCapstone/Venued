package com.motelycrue.venued.questions;

import com.motelycrue.venued.venues.Venue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    List<Questions> findByVenue(Venue venue);

    @Transactional
    @Modifying
    @Query("UPDATE Questions q SET q.answered = :answered WHERE q.id = :id")
    void updateAnsweredStatus(@Param("answered") int id, @Param("id") long questionId);
}
