package com.motelycrue.venued.services;

import com.motelycrue.venued.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class VenuedUserDetails extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public VenuedUserDetails(){}


    public VenuedUserDetails(long id, String username, String name, String password, String email, String imgPath, String bio, String profilePic) {

        super(id, username, name, password, email, imgPath, bio, profilePic);
    }
}
