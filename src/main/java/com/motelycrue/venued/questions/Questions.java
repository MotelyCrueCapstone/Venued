package com.motelycrue.venued.questions;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 510)
    private String question;

    @Column(nullable = false)
    private int answered = 0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="venueId")
    private Venue venue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answeredQuestions;

    public Questions(String question) {
        this.question = question;
    }

}
