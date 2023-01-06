package com.motelycrue.venued.about_us;

import com.motelycrue.venued.email_service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/about_us")
public class AboutUsController {

    @Autowired
    private EmailService emailService;


    @GetMapping
    public String aboutUs(){
        return "about_us";
    }

    @PostMapping("/subscribe")
    public String sendMessage(@RequestParam(name = "email") String email){
        System.out.println(email);
       emailService.prepareAndSend(
                email,
                "Subscription",
                "Thank you for subscribing to our newsletter! We will keep you updated with the latest news and events."
       );
         return "redirect:/about_us";
    }
}
