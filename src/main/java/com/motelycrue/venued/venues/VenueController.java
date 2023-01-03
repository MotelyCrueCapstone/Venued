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

//    @PostMapping ("/${venueId}")
//    public String saveVenue(@PathVariable String venuedId){
//
//        //checking if the
//        Venue venue = this.VenueDao.findVenueByVenueId(venuedId);
//        Optional<Venue> venueRecord = Optional.ofNullable(this.VenueDao.findVenueByVenueId(venuedId));
//
//
////        if(venueRecord.isPresent()){
////
////        }else{
////            VenueDao.save();
////        }
////
//        return "";
//    }
}
