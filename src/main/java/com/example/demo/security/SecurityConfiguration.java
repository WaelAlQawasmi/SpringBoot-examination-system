package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@Configuration //to configuration the  HttpSecurity
@EnableWebSecurity//to enable the  HttpSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean// to access to any class methods without create instance
    public PasswordEncoder getPasswordEncoder(){ // auto created



        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("yazan")//first user
                .password("yazan")// first user pass
                .roles("user")//first user role
                .and()
                .withUser("user2") //second user
                .password("00000")//second user password
                .roles("admin");// second user role

    }
}
