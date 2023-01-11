package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import javax.persistence.*;

import com.motelycrue.venued.votes.Vote;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Tips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String tipName;

    @Column(nullable = false, length = 510)
    private String tipContent;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="venueId")
    private Venue venue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tip")
    private List<Vote> vote;

    public Tips(String tipName, String tipContent, User user, Venue venue) {
        this.tipName = tipName;
        this.tipContent = tipContent;
        this.user = user;
        this.venue = venue;
    }

    public Tips(String tipName, String tipContent) {
        this.tipName = tipName;
        this.tipContent = tipContent;
    }

    public long getUpvotes() {
        return vote == null ? 0 :
                vote.stream().filter(vote1 ->
                        vote1.getDirection() == 1).count();
    }
    public long getDownvotes(){
        return vote == null ? 0 :
                vote.stream().filter(vote1 ->
                        vote1.getDirection() == 0).count();
    }
}
