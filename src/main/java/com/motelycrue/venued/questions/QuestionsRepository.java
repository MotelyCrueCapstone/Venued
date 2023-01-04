package com.motelycrue.venued.questions;

import com.motelycrue.venued.venues.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    List<Questions> findByVenue(Venue venue);
}
