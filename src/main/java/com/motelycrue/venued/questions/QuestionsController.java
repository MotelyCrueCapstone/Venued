package com.motelycrue.venued.questions;


import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final AnswersRepository answersDao;

    public QuestionsController(UserRepository userDao, QuestionsRepository questionsDao, AnswersRepository answersDao) {
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
        User currentUserPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> currentUser = userDao.findById(currentUserPrincipal.getId());
        if(currentUser.isPresent()){
            question.setUser(currentUser.get());
            questionsDao.save(question);
        }

        return "redirect:/questions";
    }

    @PostMapping("/{venueId}/add-answer")
    public String answerQuestion(@PathVariable String venueId,
                                 @RequestParam(name = "answer") String answer,
                                 @RequestParam(name = "questionId") String questionId,
                                 @RequestParam(name = "userId") String userId){


        Answer newAnswer = new Answer();
        newAnswer.setAnswer(answer);
        newAnswer.setUser(userDao.getUserById(Long.parseLong(userId)));

        questionsDao.findById(Long.parseLong(questionId)).ifPresent(question1 -> {
            newAnswer.setQuestion(question1);

            question1.setAnswered(1);
            question1.setAnsweredQuestion(newAnswer);
//            List <Answer> answerList = question1.getAnsweredQuestion();
//
//            answerList.add(newAnswer);
//            question1.setAnsweredQuestions(answerList);
            newAnswer.setUser_Id(userDao.getUserById(Long.parseLong(userId)));
            answersDao.save(newAnswer);
            questionsDao.save(question1);
        });

        return "redirect:/venues/" + venueId;
    }
}
