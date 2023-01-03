package com.motelycrue.venued.venues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    Venue findVenueByVenueAlias(String venueAlias);
    Venue findVenueByVenueId(String venueId);
}
