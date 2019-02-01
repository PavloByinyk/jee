package com.example.spboot.controller;


import com.example.spboot.domain.Role;
import com.example.spboot.domain.User;
import com.example.spboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        System.out.println("userList");
        ArrayList<User> list = (ArrayList<User>) userRepository.findAll();

        list.stream().forEach(System.out::println);

        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        System.out.println("userEditForm");

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping()
    public String userSave(
            @RequestParam String userName,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user, Model model){

        user.setUsername(userName);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }
}

