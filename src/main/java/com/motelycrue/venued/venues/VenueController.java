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
            String venueUrl = String.format("venues/%s", venue.get().getId());
            return venueUrl;
        }else{
            return "/";
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

    @PostMapping ("/{venueId}")
    public String saveVenue(@PathVariable String venueId, @RequestParam String venueName, @RequestParam String venueAlias, @RequestParam String imgPath, @RequestParam String longitude, @RequestParam String latitude, @RequestParam String address, @RequestParam String rating) {
        Optional<Venue> venueRecord = Optional.ofNullable(this.VenueDao.findVenueByVenueId(venueId));

        //if venue is present we aren't going to save the new venue
        if (venueRecord.isPresent()) {
            return "venue";
        } else {

            //if venue received from api isn't present we save and all associated data with it by id
            Venue venue = new Venue(venueId, venueName, venueAlias, imgPath, longitude, latitude, address, rating);
            this.VenueDao.save(venue);
            return "venue";
        }
    }

    @PostMapping("/{venueId}/add-tip")
    public String addTip(@PathVariable String venueId, @RequestParam String tipName, @RequestParam String tipContent) {
        try {
            long venueIdAsLong = Long.parseLong(venueId);
            Optional<Venue> venue = VenueDao.findById(venueIdAsLong);
            if (venue.isPresent()) {
                Tips tip = new Tips(tipContent, tipName, venue.get());
                TipsDao.save(tip);
            }
        } catch (NumberFormatException e) {
            // handle the exception here
        }
        return "redirect:/venues/" + venueId;
    }

}
