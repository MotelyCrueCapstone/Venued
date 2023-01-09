package com.motelycrue.venued.users;

import com.motelycrue.venued.venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userDao;


    @Autowired
    private VenueRepository VenueDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLogin(){
        return "users/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return "redirect:login";
    }

    @GetMapping("/profile")
    public String profile(){
        return "users/profile";
    }
}
