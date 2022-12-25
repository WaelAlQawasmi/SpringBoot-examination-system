package com.example.demo.Bootstrapping;

import com.example.demo.Entity.user;
import com.example.demo.Repositories.PrivilegeRepository;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class BootstrappingData implements CommandLineRunner  {
    boolean alreadySetup = false;




    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private   userRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        user deffult= userRepository.findByemail("wael@email.com");
        if (true==false) {
            String passwordEncoded = passwordEncoder.encode("123456");
            user users = new user("wael", "wael@email.com", passwordEncoded);
            userRepository.save(users);

            userRepository.findAll().forEach((meme) -> {
            });
        }
    }



}
