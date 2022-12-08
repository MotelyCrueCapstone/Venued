package com.motelycrue.venued.home;


import com.motelycrue.venued.services.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeRepository HomeDao;

    @GetMapping()
    @ResponseBody
    public String home() throws IOException {
        return YelpApiService.execute("mcdonalds");
    }

}
