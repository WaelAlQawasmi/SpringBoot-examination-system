package com.example.demo.security;

import ch.qos.logback.classic.Logger;
import com.example.demo.Entity.users;
import com.example.demo.Repositories.userRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class userServiceDetailes implements UserDetailsService {
    private final Logger LOG = (Logger) LoggerFactory.getLogger(userServiceDetailes.class);

    @Autowired
    userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         users user= userRepository.findByemail(username);

        if(user == null){
            LOG.info("******************************");
            throw new UsernameNotFoundException("User not authorized.");
        }
        LOG.info(">>>>>>>>>>>>"+user.getUsername());

        return user;
    }
}
