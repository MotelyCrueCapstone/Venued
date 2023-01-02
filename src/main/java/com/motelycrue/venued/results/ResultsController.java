package com.motelycrue.venued.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/results")
public class ResultsController {
    @GetMapping
    public String resultsPage(){
        return "results_page";
    }

}
