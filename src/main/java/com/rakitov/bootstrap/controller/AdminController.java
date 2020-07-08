package com.rakitov.bootstrap.controller;

import com.rakitov.bootstrap.model.Role;
import com.rakitov.bootstrap.model.User;
import com.rakitov.bootstrap.service.RoleService;
import com.rakitov.bootstrap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public String getAllUser(ModelMap modelMap) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("user", userService.findUserByEmail(email));
        modelMap.addAttribute("allUsers", userService.getAllUser());
        modelMap.addAttribute("roles", roleService.getAllRole());
        modelMap.addAttribute("title", "Admin panel");
        return "admin";
    }

    @GetMapping(value = "/add")
    public String createUpdatePage(ModelMap modelMap) {
        modelMap.addAttribute("roles", roleService.getAllRole());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute User user, String[] roles) {
        userService.saveUser(user, roles);
        return "redirect:/admin";
    }

    @GetMapping(value = "/update")
    public String createUpdatePage(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserById(id));
        modelMap.addAttribute("roles", roleService.getAllRole());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateUser(User user, String[] roles) {
        userService.updateUser(user, roles);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(User user) {
        userService.removeUser(user.getId());
        return "redirect:/admin";
    }
}
