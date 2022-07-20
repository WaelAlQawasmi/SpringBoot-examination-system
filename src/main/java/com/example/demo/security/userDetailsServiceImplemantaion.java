package com.example.demo.security;

import com.example.demo.Rebosotory.usersRebosotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // to create service
public class userDetailsServiceImplemantaion implements UserDetailsService {
    @Autowired // to access to privet Properties
    usersRebosotory usersrebosotory;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {// you must added
        return usersrebosotory.findByusername(username);
    }
}
