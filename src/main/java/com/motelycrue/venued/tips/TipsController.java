package com.motelycrue.venued.tips;

import com.motelycrue.venued.questions.Questions;
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
@RequestMapping("/tips")
public class TipsController {

    @Autowired
    private TipsRepository tipsDao;

    private final UserRepository userDao;

    public TipsController(UserRepository userDao, TipsRepository tipsDao ) {
        this.userDao = userDao;
        this.tipsDao = tipsDao;
    }

    @GetMapping()
    public String tipForm(Model model) {
        List<Tips> tips = tipsDao.findAll();
        model.addAttribute("tips", tips);
        model.addAttribute("tip", new Tips());
        return "/venue";
    }

    @PostMapping()
    public String createTips(@ModelAttribute Tips tip){
        User user = userDao.findAll().get(0);
        tip.setUser(user);
        tipsDao.save(tip);
        return "venue";
    }

}
