package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
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
public class Tips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
