package com.motelycrue.venued.questions;

import com.motelycrue.venued.users.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


public class QuestionsJson {

    private Long id;

    private String question;

    private User user;

}
