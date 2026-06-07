package com.cmpt276_cs_prof_rate.demo.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmpt276_cs_prof_rate.demo.models.Users;
import com.cmpt276_cs_prof_rate.demo.services.FetchUsers;

@Controller
public class UsersController {

    private final FetchUsers fetchUsers;

    public UsersController(FetchUsers fetchUsers) {
        this.fetchUsers = fetchUsers;
    }

    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        List<Users> users = fetchUsers.loadData();

        model.addAttribute("users", users);

        return "users/showAll";
    }
}