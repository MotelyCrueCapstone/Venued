package com.motelycrue.venued.users;

import com.motelycrue.venued.questions.Answer;
import com.motelycrue.venued.questions.AnswersRepository;
import com.motelycrue.venued.questions.Questions;
import com.motelycrue.venued.questions.QuestionsRepository;
import com.motelycrue.venued.tips.Tips;
import com.motelycrue.venued.tips.TipsRepository;
import com.motelycrue.venued.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private QuestionsRepository questionsDao;

    @Autowired
    private TipsRepository TipsDao;

    @Autowired
    private AnswersRepository answersDao;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String showLogin(HttpServletRequest request) {
        String url = request.getHeader("referer");
        request.getSession().setAttribute("url_prior_login", url);

        System.out.println(url);
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
        user.setImgPath("/imgs/avatar-image.png");
        userDao.save(user);
        return "redirect:login";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        User currentUserPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> currentUser = userDao.findById(currentUserPrincipal.getId());
        System.out.println("This is inside userController.");
        System.out.println(currentUser);
        if(currentUser.isPresent()){
            List<Questions> allQuestions = questionsDao.findQuestionsByUser(currentUser.get());
            model.addAttribute("user", currentUser.get());
            model.addAttribute("allQuestions", allQuestions);
            model.addAttribute("allQuestionsLength", allQuestions.size());

            List<Answer> allAnswers = answersDao.findAnswersByUser(currentUser.get());
            model.addAttribute("user", currentUser.get());
            model.addAttribute("allAnswers", allAnswers);
            model.addAttribute("allAnswersLength", allAnswers.size());

            List<Tips> allTips = TipsDao.findTipsByUser(currentUser.get());
            model.addAttribute("user", currentUser.get());
            model.addAttribute("allTips", allTips);
            model.addAttribute("allTipsLength", allTips.size());

            return "users/profile";
        }else {
            return "redirect:/home";
        }
    }

    @GetMapping("/user-info")
    public String showProfileForm(Model model) {
        User currentUser = userDao.getUserById(Utils.currentUserId());
        model.addAttribute("user", currentUser);
        return "users/profile";
    }

    @PostMapping("/user-info")
    public String userProfileInfo(@ModelAttribute User user, @RequestParam(name = "name") String name, @RequestParam(name = "bio") String bio) {
        User currentUser = userDao.getUserById(Utils.currentUserId());
        currentUser.setName(name);
        currentUser.setBio(bio);
        userDao.save(currentUser);
        return "users/profile";
    }


    @PostMapping("/profilePic")
    public String profileImage(@RequestParam (name="profilePicInput") String url) {
        User user = userDao.getUserById(Utils.currentUser().getId());
        user.setImgPath(url);
        userDao.save(user);
        return "redirect:/profile";
    }
}
