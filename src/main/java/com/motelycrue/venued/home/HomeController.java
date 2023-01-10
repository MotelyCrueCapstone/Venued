package com.motelycrue.venued.home;


import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;
import com.motelycrue.venued.yelp_api.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private YelpApiService yelpApiService;

    @Autowired
    private QuestionsRepository QuestionsDao;


    @GetMapping("/home")
    public String homepageAlternative(){

        return "index";
    }

    @GetMapping("/")
    public String homepage(Model model){
        List<Questions> questions = QuestionsDao.findFirst30ByOrderByIdDesc();
        model.addAttribute("questions", questions);
        return "index";
    }

}

