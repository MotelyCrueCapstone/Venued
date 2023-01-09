package com.motelycrue.venued.questions;


import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsDao;

    @Autowired
    private final UserRepository userDao;

    @Autowired
    private final answersRepository answersDao;

    public QuestionsController(UserRepository userDao, QuestionsRepository questionsDao, answersRepository answersDao) {
        this.questionsDao = questionsDao;
        this.userDao = userDao;
        this.answersDao = answersDao;
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

    @PostMapping("/{venueId}/add-answer")
    public String answerQuestion(@PathVariable long venueId,
                                 @RequestParam(name = "answer") String answer,
                                 @RequestParam(name = "questionId") long questionId,
                                 Principal principal){


        Answer newAnswer = new Answer();
        newAnswer.setAnswer(answer);
        newAnswer.setUser(userDao.findByUsername(principal.getName()));

        questionsDao.findById(questionId).ifPresent(question1 -> {
            newAnswer.setQuestion(question1);
            question1.setAnswered(1);
            answersDao.save(newAnswer);
            questionsDao.save(question1);
        });

        return "redirect:/venues/" + venueId;
    }
}
