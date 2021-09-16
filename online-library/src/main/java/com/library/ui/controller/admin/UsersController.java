package com.library.ui.controller.admin;

import com.library.ui.dto.UserSaveDto;
import com.library.ui.service.RoleService;
import com.library.ui.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final RoleService roleService;
    private static final String url = "http://localhost:9999/users";

    public UsersController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("user", new UserSaveDto());
        return "_admin/users";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(name = "user") UserSaveDto user, Model model) {
        userService.save(user);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAllRoles());
        return "redirect:" + url;
    }
}
