package com.motelycrue.venued.questions;


import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsDao;

    @Autowired
    private UserRepository UserDao;
}
