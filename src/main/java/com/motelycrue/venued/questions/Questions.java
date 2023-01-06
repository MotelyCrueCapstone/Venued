package com.motelycrue.venued.questions;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.venues.Venue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int answered;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="venueId")
    private Venue venue;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="answer_id")
    private Answer answeredQuestions;

    public Questions(String question) {
        this.question = question;
    }
}
