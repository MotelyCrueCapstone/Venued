package com.motelycrue.venued.venues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venues")
public class VenueController {


    @Autowired
    private VenueRepository VenueDao;

    @GetMapping()
    public String showVenuePage() {
        return "venue";
    }


}
