package com.motelycrue.venued.badge;

import com.motelycrue.venued.questions.QuestionsRepository;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private final BadgeRepository badgeDao;

    private final UserRepository UserDao;

    private final QuestionsRepository QuestionsDao;

    public BadgeController(BadgeRepository badgeDao, UserRepository userDao, QuestionsRepository questionsDao) {
        this.badgeDao = badgeDao;
        this.UserDao = userDao;
        this.QuestionsDao = questionsDao;
    }
}
