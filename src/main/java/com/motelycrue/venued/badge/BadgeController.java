package com.motelycrue.venued.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeRepository badgeDao;
}
