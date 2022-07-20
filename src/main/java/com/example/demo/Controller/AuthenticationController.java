package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;

@Controller
public class AuthenticationController {

    @ResponseStatus(value = HttpStatus.OK) // to cheake the resopnse
    @GetMapping("/") // to create  route
    String hello(){
        System.out.println("hello world !");
        return ("gi");

    }

    @GetMapping("/user")
    public  String admin(Model username, Principal currentLogedIn){
        username.addAttribute("userName",currentLogedIn.getName());

        return "gi.html";
    }

    @GetMapping("/all")
    public  String all(Model username, Principal currentLogedIn){
        username.addAttribute("userName",currentLogedIn.getName());

        return "gi.html";
    }

    @GetMapping("/admin")
    public  String user(Model role){
role.addAttribute("Myrole","admin");
        return "gi.html";
    }
}
