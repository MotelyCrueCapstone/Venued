package com.motelycrue.venued.configuration;

import com.motelycrue.venued.users.User;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {
    // Bean to configure filter chain and set which pages must be authorized to view
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize)-> {
            authorize.anyRequest().permitAll();
//            authorize.requestMatchers("/","/home", "/venues/**").permitAll();
//            authConfig.requestMatchers("/").permitAll().and(;
//            authConfig.requestMatchers("/home").permitAll();
//            authConfig.requestMatchers("/login").permitAll();
//            authConfig.requestMatchers("/register").permitAll();
//            authConfig.requestMatchers("/venues").authenticated();

        });
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    UserDetailsService userDetailsService(){
//        var admin = User.builder()
//                .userName("admin")
//                .password("admin123")
//                .build();
//        var user = User.builder()
//                .userName()
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return encoder;
//    }

}


