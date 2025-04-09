package cz.uhk.pro2_c.controller;

import cz.uhk.pro2_c.model.User;
import cz.uhk.pro2_c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("users", userService.getUsers());
        return "users_list";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getUser(id));
        return "users_detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getUser(id));
        return "users_add";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getUser(id));
        return "users_delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteConfirm(Model model, @PathVariable long id){
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "users_add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/";
    }

}
