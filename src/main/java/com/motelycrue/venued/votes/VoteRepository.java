package com.motelycrue.venued.votes;

import com.motelycrue.venued.tips.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByDirectionLessThanEqual(Integer direction);
    List<Vote> findByDirectionGreaterThanEqual(Integer direction);

}
