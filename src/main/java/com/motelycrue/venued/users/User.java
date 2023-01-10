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

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column
    private String imgPath;

    @Column(nullable = false)
    private String bio;

//    public User(long id, String email, String username, String password) {
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String userName){
        this.username = userName;
    }
}
