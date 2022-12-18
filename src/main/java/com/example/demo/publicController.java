package com.example.demo;

import com.example.demo.Entity.users;
import com.example.demo.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class publicController {
    @Autowired
    userRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/signup")
    public RedirectView signupPost(@RequestParam String password, @RequestParam String email, @RequestParam String name) {

        if (userRepository.findByemail(email) == null) {
            String passwordEncoded = passwordEncoder.encode(password);
            users user = new users(name, email, passwordEncoded);
            userRepository.save(user);
            return new RedirectView("/login");
        } else {
            return new RedirectView("/signup?taken=true");
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal p, Model model) {
String name= userRepository.findByemail(p.getName()).getName();

        model.addAttribute("userInfo",name);

        return "dashboard";
    }



    @GetMapping("/exams")
    public String exams() {
        return "exams";
    }

}
