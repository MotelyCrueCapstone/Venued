package com.motelycrue.venued.home;


import com.motelycrue.venued.yelp_api.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private YelpApiService yelpApiService;

    @GetMapping("/")
    public String homepage(){
        return "index";
    }
    @GetMapping("/home")
    public String homepageAlternative(){
        return "redirect: /";
    }

}

