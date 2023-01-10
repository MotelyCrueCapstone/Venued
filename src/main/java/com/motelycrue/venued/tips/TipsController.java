package com.motelycrue.venued.tips;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import com.motelycrue.venued.votes.Vote;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/vote/{direction}")
    public String handleVote(@PathVariable String direction,
                             @RequestParam Long tipId,
                             @RequestParam Long userId){

        Optional<Tips> tip = tipsDao.findById(tipId);
        Optional<User> currentUser = userDao.findById(userId);

        if (tip.isPresent() && currentUser.isPresent()) {
            int voteDirection = Integer.parseInt(direction);

            Vote vote = Vote.builder()
                    .direction(voteDirection)
                    .tip(tip.get())
                    .user(currentUser.get())
                    .build();

            tip.get().getVote().add(vote);
            tipsDao.save(tip.get());
        }

        return String.format("redirect:/venues/%d",
                tip.get().getVenue().getId());
    }


}



