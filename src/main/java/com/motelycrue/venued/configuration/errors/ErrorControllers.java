package com.motelycrue.venued.configuration.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorControllers {
    @GetMapping("/404")
    public String notFound(){
        return "errors/404";
    }
}
