package com.motelycrue.venued.questions;


import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private final QuestionsRepository questionsDao;

    private final UserRepository UserDao;

    public QuestionsController(QuestionsRepository questionsDao, UserRepository userDao) {
        this.questionsDao = questionsDao;
        this.UserDao = userDao;
    }
}
