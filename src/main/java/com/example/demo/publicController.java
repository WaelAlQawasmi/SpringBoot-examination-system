package com.example.demo;

import com.example.demo.Entity.exams;
import com.example.demo.Entity.users;
import com.example.demo.Repositories.examsRepository;
import com.example.demo.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class publicController {
    @Autowired
    userRepository userRepository;
    @Autowired
    examsRepository  examsRepository;
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

    @PostMapping("/create/exam")
    @ResponseBody

    public  RedirectView createExam( @RequestParam Map<String,String> allParams,Principal user) {
       users crestedUser= userRepository.findByemail(user.getName());
        exams newExams=new exams(allParams.get("name"),allParams.get("date"),allParams.containsKey("inEnable"),100,allParams.get("category"),allParams.get("subject"),crestedUser);
        examsRepository.save(newExams);
        return new RedirectView("/dashboard");

    }
        @GetMapping("/dashboard")
    public String dashboard(Principal p, Model model) {
    String name= userRepository.findByemail(p.getName()).getName();
    List<exams>exams=examsRepository.findAll();

        model.addAttribute("userInfo",name);
        model.addAttribute("exams",exams);

        return "dashboard";
    }



    @GetMapping("/exams")
    public String exams() {
        return "exams";
    }

}
