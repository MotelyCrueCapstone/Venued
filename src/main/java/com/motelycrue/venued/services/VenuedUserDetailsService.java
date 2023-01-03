//package com.motelycrue.venued.services;
//
//import com.motelycrue.venued.users.User;
//import com.motelycrue.venued.users.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class VenuedUserDetailsService implements UserDetailsService {
//
//    public final UserRepository usersDao;
//
//    public VenuedUserDetailsService(UserRepository usersDao) {
//        this.usersDao = usersDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = usersDao.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User details not found for user: " + username);
//        } else {
//            return new VenuedUserDetails(user.getId(), user.getUserName(), user.getEmail(), user.getPassword());
//        }
//
//    }
//
//
//}
