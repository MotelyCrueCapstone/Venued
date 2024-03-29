package com.motelycrue.venued.answer;

import com.motelycrue.venued.questions.Questions;
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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(nullable = false, length = 510)
    private String answer;

    @Column
    private Long upVotes;

    @Column
    private Long downVotes;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="question_id")
    private Questions question;

    public Answer(String answer) {
        this.answer = answer;
    }

    // getQuestion() method
    public Questions getQuestion() {
        return this.question;
    }


    // setQuestion() method
    public void setQuestion(Questions question) {
        this.question = question;
    }

    public void setUser_Id(User userById) {
        this.user = userById;
    }
}
