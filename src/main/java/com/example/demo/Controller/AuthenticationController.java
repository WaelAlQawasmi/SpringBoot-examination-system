package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AuthenticationController {

    @ResponseStatus(value = HttpStatus.OK) // to cheake the resopnse
    @GetMapping("/") // to create  route
    String hello(){
        System.out.println("hello world !");
        return ("gi");

    }

    @GetMapping("/user")
    public  String admin(){

        return "gi.html";
    }


    @GetMapping("/admin")
    public  String user(Model role){
role.addAttribute("Myrole","admin");
        return "gi.html";
    }
}
