package com.motelycrue.venued.tips;

import com.motelycrue.venued.venues.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipsRepository extends JpaRepository<Tips, Long> {
    List<Tips> findByVenue(Venue venue);

}
