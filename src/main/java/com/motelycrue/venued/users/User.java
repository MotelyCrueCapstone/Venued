package com.motelycrue.venued.users;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = true, length = 50)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column
    private String imgPath;

    @Column(nullable = true, length = 510)
    private String bio;

    @Column
    private String profilePic;

//    public User(String name, String bio) {
//        this.name = name;
//        this.bio = bio;
//    }


//    public User(long id, String email, String username, String password) {
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }
}
