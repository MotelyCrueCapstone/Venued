package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String tipName;

    @Column(nullable = false)
    private String tipContent;

    @Column
    private Long upVotes;

    @Column
    private Long downVotes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="venueId")
    private Venue venue;

    public Tips(String tipName, String tipContent) {
        this.tipName = tipName;
        this.tipContent = tipContent;
    }

    public Tips(String tipContent, String tipName, Venue venue) {
        this.tipContent = tipContent;
        this.venue = venue;
        this.tipName = tipName;
    }

    public Tips(String tipName, String tipContent, Long upVotes, Long downVotes) {
        this.tipName = tipName;
        this.tipContent = tipContent;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }
}
