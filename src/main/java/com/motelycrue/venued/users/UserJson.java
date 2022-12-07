package com.motelycrue.venued.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class UserJson {

    private Long id;
    private String userName;
    private String password;
    private String email;
}
