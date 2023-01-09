package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class TipsJson {


    private Long id;

    private String tipName;

    private String tipContent;

    private Long upVotes;

    private Long downVotes;
    private User user;



}
