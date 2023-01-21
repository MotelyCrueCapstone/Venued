package com.motelycrue.venued.questions;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {


    //find questions by venue
    List<Questions> findByVenue(Venue venue);

    //find questions by user who posted them
    List<Questions> findQuestionsByUser(User user);

    List<Questions> findFirst30ByOrderByIdDesc();

    List<Questions> findQuestionsByAnsweredEqualsAndVenue(int answered, Venue venue);


    List<Questions> findFirst30ByAnsweredEqualsOrderByIdDesc(int answered);



}
