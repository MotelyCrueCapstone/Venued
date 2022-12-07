package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class TipsJson {


    private Long id;

    private String tip_Name;

    private String tip_Content;

    private Long upVotes;

    private Long downVotes;
    private User user;



}
