package com.motelycrue.venued.answer;

import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AnswerController {

    @Autowired
    private AnswersRepository answersDao;


    @PostMapping("/editUserAnswer")
    public String editUserQuestion(@RequestParam String answer, @RequestParam String answerId){
        Optional<Answer> answers = Optional.ofNullable(answersDao.findById(Long.parseLong(answerId)));
        if(answers.isPresent()){
            answers.get().setAnswer(answer);
            answersDao.save(answers.get());
        }
        return "redirect:/profile";
    }

    @PostMapping("/deleteUserAnswer")
    public String deleteUserQuestion(@RequestParam(name="answerId") String answerId) {
        Optional<Answer> answers = Optional.ofNullable(answersDao.findById(Long.parseLong(answerId)));
        answers.ifPresent(answer -> answersDao.delete(answer));
        return "redirect:/profile";
    }
}
