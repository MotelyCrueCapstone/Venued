package com.motelycrue.venued.questions;


import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsDao;

    private final UserRepository userDao;

    public QuestionsController(UserRepository userDao, QuestionsRepository questionsDao) {
        this.questionsDao = questionsDao;
        this.userDao = userDao;
    }


    @GetMapping()
    public String createController(Model model){
        List<Questions> questions = questionsDao.findAll();
        model.addAttribute("questions", questions);
        model.addAttribute("emptyQuestions", new Questions());
        return "questions";
    }

    @PostMapping()
    public String createQuestions(@ModelAttribute Questions question){
        User user = userDao.findAll().get(0);
        question.setUser(user);
        questionsDao.save(question);
        return "redirect:/questions";
    }
}
