package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipsRepository extends JpaRepository<Tips, Long> {

    List<Tips> findByVenue(Venue venue);

    //find all tips by user who posted them
    List<Tips> findTipsByUser(User user);

//    List<Tips> findTop20(List<Tips> tips);

}
