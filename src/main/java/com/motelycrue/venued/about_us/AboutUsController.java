package com.motelycrue.venued.about_us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about_us")
public class AboutUsController {

    @GetMapping
    public String aboutUs(){
        return "/about_us";
    }

}
