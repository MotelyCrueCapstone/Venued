package com.motelycrue.venued.home;


import com.motelycrue.venued.services.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private YelpApiService yelpApiService;

    @GetMapping(value = "/yelp" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String yelp() throws IOException {
        return yelpApiService.execute("clubs");
    }

}

