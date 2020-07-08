package com.rakitov.bootstrap.controller;


import com.rakitov.bootstrap.model.User;
import com.rakitov.bootstrap.service.RoleService;
import com.rakitov.bootstrap.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userPage(ModelMap modelMap) {
        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        modelMap.addAttribute("user", user);
        return "/user";
    }

}
