package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration //to configration the  HttpSecurity
@EnableWebSecurity//to enable the  HttpSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {  //

    @Autowired
    userDetailsServiceImplemantaion userDetailsService;

    @Bean // to create methode  return  instance like here
    public PasswordEncoder getPasswordEncoder(){ // auto created

          //  PasswordEncoder encoder = new BCryptPasswordEncoder();// to select the encode this for endoe password


        return NoOpPasswordEncoder.getInstance(); // this to disable the encoding just can add password direct in database

        }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());


//
//        auth.inMemoryAuthentication()
//                .withUser("yazan")//first user
//                .password(getPasswordEncoder().encode("yazan"))// first user pass
//                .roles("user")//first user role
//                .and()
//                .withUser("user2") //second user
//                .password("00000")//second user password
//                .roles("admin");// second user role

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
        .authorizeRequests()
        .antMatchers("/user").hasAnyAuthority("user") // to  access  to rout just for user Role (Authority @override in  userDetiles entity)
        .antMatchers("/admin").hasAnyAuthority("admin") // to  access to rout just for admin Role (Authority @override in  userDetiles entity)
        .antMatchers("/all").hasAnyAuthority("user","admin") // to get access to rout just for any Role(Authority @override in  userDetiles entity)
        .antMatchers("/").permitAll()// to get access to rout for un Authenticated user
        .and()
        .formLogin();

    }
}
