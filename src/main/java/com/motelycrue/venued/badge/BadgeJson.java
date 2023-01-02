package com.motelycrue.venued.badge;

import com.motelycrue.venued.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class BadgeJson {


    private Long id;

    private String badge_name;

    private String badge_img;

    private User user;
}
