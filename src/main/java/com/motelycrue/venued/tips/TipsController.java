package com.motelycrue.venued.tips;

import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import com.motelycrue.venued.venues.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return "venue";
    }

    @PostMapping("/vote")
    public String handleVote(@RequestBody Vote vote){
        Optional<Tips> tip = tipsDao.findById(vote.getTipId());
        if(tip.isPresent()){
            if(vote.getDirection().equals("up")){
                tip.get().setUpVotes(tip.get().getUpVotes() + 1);
            } else {
                tip.get().setDownVotes(tip.get().getDownVotes() + 1);
            }
            tipsDao.save(tip.get());
        }
        return null;
    }

}



