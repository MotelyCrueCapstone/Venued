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

//    @Autowired
//    private final EmailService emailService;
//
//    public AboutUsController(EmailService emailService) {
//        this.emailService = emailService;
//    }


    @GetMapping
    public String aboutUs(){
        return "/about_us";
    }

//    @PostMapping("/contact")
//    @ModelAttribute("contact")
//    public String contactUs(@RequestParam("subject") String subject, @RequestParam("email") String email, @RequestParam("message") String message, Model model){
//        emailService.prepareAndSend(subject, message, email);
//        model.addAttribute("subject", subject);
//        model.addAttribute("email", email);
//        model.addAttribute("message", message);
//        return "redirect:/about_us";
//    }
}
