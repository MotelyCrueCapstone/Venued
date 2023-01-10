package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import javax.persistence.*;

import lombok.*;

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

    @Column(nullable = false)
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
}
