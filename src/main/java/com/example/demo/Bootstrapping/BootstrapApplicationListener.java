package com.example.demo.Bootstrapping;

import com.example.demo.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BootstrapApplicationListener implements ApplicationListener<ContextRefreshedEvent> {


    //Repository
    private final  userRepository userRepository;



    public BootstrapApplicationListener(userRepository memeRepository ,PasswordEncoder passwordEncoder) {
        this.userRepository = memeRepository;
        this.passwordEncoder = passwordEncoder;
    }
@Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        String passwordEncoded = passwordEncoder.encode("123456");
//        users users = new users("wael","wael@email.com",passwordEncoded,"admin",Boolean.FALSE);
//        userRepository.save(users);
    }
}