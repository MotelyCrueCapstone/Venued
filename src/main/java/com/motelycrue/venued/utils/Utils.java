package com.motelycrue.venued.utils;

import com.motelycrue.venued.users.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static long currentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
