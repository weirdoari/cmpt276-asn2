package com.cmpt276_cs_prof_rate.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @GetMapping("/users/view")
    public String getAllUseers(){
        System.out.println(x:"Geting all users");
        // TODO : get all users from DB
        
        return "users/showAll";
    }
   
}
