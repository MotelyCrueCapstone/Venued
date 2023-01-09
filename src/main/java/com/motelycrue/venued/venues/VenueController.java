package com.motelycrue.venued.venues;

import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;
import com.motelycrue.venued.tips.Tips;
import com.motelycrue.venued.tips.TipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
            model.addAttribute("venue", venue.get());
            List<Tips> tips = TipsDao.findByVenue(venue.get());
            model.addAttribute("tips", tips);
            List<Questions> questions = QuestionsDao.findByVenue(venue.get());
            model.addAttribute("questions", questions);
        }
        return "venue";
    }

    @GetMapping ("create/{venueId}")
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
        return "venue";
    }

    @PostMapping("/{venueId}/add-tip")
    public String addTip(@PathVariable String venueId, @RequestParam String tipName, @RequestParam String tipContent,
     @RequestParam Long upVotes, @RequestParam Long downVotes) {
        Optional<Venue> venue = VenueDao.findById(Long.parseLong(venueId));
        if (venue.isPresent()) {
            Tips tip = new Tips(tipName, tipContent, upVotes, downVotes);
            tip.setVenue(venue.get());
            TipsDao.save(tip);
        }
        return "redirect:/venues/{venueId}";
    }

    @PostMapping("/{venueId}/add-question")
    public String addQuestion(@PathVariable String venueId,  @RequestParam String question) {
        Optional<Venue> venue = VenueDao.findById(Long.parseLong(venueId));
        if (venue.isPresent()) {
            Questions newQuestion = Questions.builder()
                    .question(question)
                    .venue(venue.get())
                    .build();
            QuestionsDao.save(newQuestion);
        }
        return "redirect:/venues/{venueId}";
    }







}
