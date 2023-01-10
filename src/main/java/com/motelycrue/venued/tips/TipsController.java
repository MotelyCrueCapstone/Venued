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
    public ResponseEntity<Void> handleVote(@RequestBody Vote vote){
        Optional<Tips> optionalTip = tipsDao.findById(vote.getTipId());
        if(optionalTip.isEmpty()){
            return ResponseEntity.notFound().build();
    }
    Tips tip = optionalTip.get();
    if(vote.getDirection().equals("up")){
        tip.setUpVotes(tip.getUpVotes() + 1);
    }else if (vote.getDirection().equals("down")){
        tip.setDownVotes(tip.getDownVotes() + 1);
    }
    tipsDao.save(tip);
    return ResponseEntity.ok().build();
    }
}



