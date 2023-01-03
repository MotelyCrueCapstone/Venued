package com.motelycrue.venued.venues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueRepository VenueDao;

    @GetMapping()
    public String showVenuePage() {
        return "venue";
    }

    @PostMapping ("/${venueId}")
    public String saveVenue(@PathVariable String venueId, @RequestParam String venueName, @RequestParam String venueAlias, @RequestParam String imgPath, @RequestParam String longitude, @RequestParam String latitude, @RequestParam String address, @RequestParam String rating) {
        Optional<Venue> venueRecord = Optional.ofNullable(this.VenueDao.findVenueByVenueId(venueId));


        //if venue is present we arent going to save the new venue
        if (venueRecord.isPresent()) {
            return "venue";
        } else {
            //if venue recieved from api isnt present we save and all associated data with it by id
            Venue venue = new Venue(venueId, venueName, venueAlias, imgPath, longitude, latitude, address, rating);
            this.VenueDao.save(venue);
            return "venue";
        }
    }
}
