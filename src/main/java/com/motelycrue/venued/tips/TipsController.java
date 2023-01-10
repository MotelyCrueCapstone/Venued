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

    @PostMapping("/tips/vote/{direction}")
    public String handleVote(@PathVariable String direction,@RequestParam Long tipId) {
        Optional<Tips> tip = tipsDao.findById(tipId);
        if (tip.isPresent()) {
            int voteDirection = Integer.parseInt(direction);

            Vote vote = Vote.builder()
                    .direction(voteDirection).
            tip(tip.get()).build();
            tip.get().getVote().add(vote);
            tipsDao.save(tip.get());
        }

        return String.format("redirect:/venues/%d",
                tip.get().getVenue().getId());
    }
}



