package com.motelycrue.venued.home;


import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;

import com.motelycrue.venued.tips.Tips;
import com.motelycrue.venued.tips.TipsRepository;

import com.motelycrue.venued.yelp_api.YelpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private YelpApiService yelpApiService;

    @Autowired
    private QuestionsRepository QuestionsDao;



    @GetMapping("/home")
    public RedirectView homepageAlternative(){
        return new RedirectView("/");
    }

    @GetMapping("/")
    public String homepage(Model model){

        List<Questions> questions = QuestionsDao.findFirst30ByOrderByIdDesc();
        List<Questions> allQuestions = QuestionsDao.findAll();
        model.addAttribute("questions", allQuestions);
        return "index";
    }

    @GetMapping("/loadMore/{currentSet}")
    public List<Questions> loadMoreQuestions(@PathVariable int currentSet) {
        List<Questions> questions = QuestionsDao.findAll();
        int start = currentSet * 3;
        int end = start + 3;
        return questions.subList(start, end);
    }


}

