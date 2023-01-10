package com.motelycrue.venued.venues;

import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;
import com.motelycrue.venued.tips.Tips;
import com.motelycrue.venued.tips.TipsRepository;
import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private VenueRepository VenueDao;

    @Autowired
    private TipsRepository TipsDao;

    @Autowired
    private QuestionsRepository QuestionsDao;

    @GetMapping("/id/{venueId}")
    public String actualVenue(@PathVariable String venueId){
        Optional<Venue> venue = Optional.ofNullable(VenueDao.findVenueByVenueId(venueId));
        if(venue.isPresent()){
            return String.format("redirect:/venues/%s", venue.get().getId());
        }else{
            return "redirect:/home";
        }
    }


    @GetMapping("/{venueId}")
    public String showVenuePage(@PathVariable String venueId, Model model) {
        Optional<Venue> venue = VenueDao.findById(Long.parseLong(venueId));
        if (venue.isPresent()) {

            if( SecurityContextHolder.getContext().getAuthentication() != null &&
                    SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User currentUserPrinciple){

                User currentUser =  (User) userDao.getUserById(currentUserPrinciple.getId());


                model.addAttribute("user", currentUser);
            }


            model.addAttribute("venue", venue.get());

            List<Tips> tips = TipsDao.findByVenue(venue.get());

            model.addAttribute("tips", tips);

            List<Questions> questions = QuestionsDao.findByVenue(venue.get());
            model.addAttribute("questions", questions);

            model.addAttribute("newQuestion",  new Questions());
        }
        return "venue";
    }

    @GetMapping ("create/{venueId}")
    @ResponseBody
    public String saveVenue(@PathVariable String venueId,
                            @RequestParam String venueName,
                            @RequestParam String venueAlias,
                            @RequestParam String imgPath,
                            @RequestParam String longitude,
                            @RequestParam String latitude,
                            @RequestParam String address,
                            @RequestParam String rating) {
        Optional<Venue> venueRecord = Optional.ofNullable(this.VenueDao.findVenueByVenueId(venueId));

        //if venue is present we aren't going to save the new venue
        if (venueRecord.isEmpty()) {
            //if venue received from api isn't present we save and all associated data with it by id
            Venue venue = Venue.builder()
                    .venueId(venueId)
                    .venueName(venueName)
                    .venueAlias(venueAlias)
                    .imgPath(imgPath)
                    .longitude(longitude)
                    .latitude(latitude)
                    .address(address)
                    .rating(rating).build();
            this.VenueDao.save(venue);
        }
        return HttpStatus.OK.toString();
    }

    @PostMapping("/{venueId}/add-tip")
    public String addTip(@PathVariable String venueId, @RequestParam String tipName, @RequestParam String tipContent,
     @RequestParam Long upVotes, @RequestParam Long downVotes) {
        Optional<Venue> venue = VenueDao.findById(Long.parseLong(venueId));User currentUserPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> currentUser = userDao.findById(currentUserPrincipal.getId());
        if (venue.isPresent() && currentUser.isPresent()) {
            Tips tip = new Tips(tipName, tipContent);
            tip.setVenue(venue.get());
            tip.setUser(currentUser.get());
            TipsDao.save(tip);
        }
        return "redirect:/venues/{venueId}";
    }

    @PostMapping("/{venueId}/add-question")
    public String addQuestion(@PathVariable String venueId,  @RequestParam String question) {
        Optional<Venue> venue = VenueDao.findById(Long.parseLong(venueId));
        User currentUserPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> currentUser = userDao.findById(currentUserPrincipal.getId());

        if (venue.isPresent() && currentUser.isPresent()) {
            Questions newQuestion = Questions.builder()
                    .question(question)
                    .user(currentUser.get())
                    .venue(venue.get())
                    .build();
            QuestionsDao.save(newQuestion);
        }
        return "redirect:/venues/{venueId}";
    }
}
