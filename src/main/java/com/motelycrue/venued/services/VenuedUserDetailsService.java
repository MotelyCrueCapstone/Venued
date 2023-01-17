package com.motelycrue.venued.services;

import com.motelycrue.venued.users.User;
import com.motelycrue.venued.users.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VenuedUserDetailsService implements UserDetailsService {
    //automatically inject users repository dao
    private final UserRepository userRepository;

    public VenuedUserDetailsService(UserRepository usersRepository){
        this.userRepository = usersRepository;
    }
    //loads user data from the dao and checks it against user input
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository. findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("UserDetails Not found");
        } else{
            return new VenuedUserDetails(
                    user.getId(),
                    user.getName(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getImgPath(),
                    user.getBio());
        }
    }
}
