package com.motelycrue.venued.venues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venues")
public class VenueController {

    private final VenueRepository VenueDao;


    public VenueController(VenueRepository venueDao) {
        VenueDao = venueDao;
    }
}
