package com.motelycrue.venued.questions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private final QuestionsRepository questionsDao;

    public QuestionsController(QuestionsRepository questionsDao) {
        this.questionsDao = questionsDao;
    }
}
