package com.motelycrue.venued.answer;

import com.motelycrue.venued.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends JpaRepository<Answer, Long> {

    //get all answers by user who posted them
    List<Answer> findAnswersByUser(User user);

    Answer findById(long id);
}
