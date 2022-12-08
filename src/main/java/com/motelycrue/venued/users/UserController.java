package com.motelycrue.venued.users;

import com.motelycrue.venued.badge.BadgeRepository;
import com.motelycrue.venued.venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private BadgeRepository BadgeDao;

    private VenueRepository VenueDao;

}
