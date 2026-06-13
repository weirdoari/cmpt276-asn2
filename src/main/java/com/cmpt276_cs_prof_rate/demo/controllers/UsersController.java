package com.cmpt276_cs_prof_rate.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmpt276_cs_prof_rate.demo.models.Users;
import com.cmpt276_cs_prof_rate.demo.repositories.CommentRepository;
import com.cmpt276_cs_prof_rate.demo.repositories.UserRepository;
import com.cmpt276_cs_prof_rate.demo.services.FetchUsers;

@Controller
public class UsersController {

    private final CommentRepository commentRepository;
    private final FetchUsers fetchUsers;
    private final UserRepository userRepository;

    public UsersController(FetchUsers fetchUsers, UserRepository userRepository, CommentRepository commentRepository) {
        this.fetchUsers = fetchUsers;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        List<Users> fetchedUsers = fetchUsers.loadData();

        for (Users user : fetchedUsers) {
            if (!userRepository.existsByName(user.getName())) {
                userRepository.save(user);
            }
        }

        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("comment", commentRepository.findAll());

        return "users/showAll";
    }
}