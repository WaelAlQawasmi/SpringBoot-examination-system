package com.example.demo.Bootstrapping;

import com.example.demo.Entity.users;
import com.example.demo.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class BootstrappingData implements CommandLineRunner  {

    @Autowired
    private PasswordEncoder passwordEncoder;
    //Repository
    private final  userRepository userRepository;

    public BootstrappingData(userRepository memeRepository , PasswordEncoder passwordEncoder) {
        this.userRepository = memeRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        users deffult= userRepository.findByemail("wael@email.com");
        if (deffult==null) {
            String passwordEncoded = passwordEncoder.encode("123456");
            users users = new users("wael", "wael@email.com", passwordEncoded, Boolean.FALSE);
            userRepository.save(users);

            userRepository.findAll().forEach((meme) -> {
            });
        }
    }



}
