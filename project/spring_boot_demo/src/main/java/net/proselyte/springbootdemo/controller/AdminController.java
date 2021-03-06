package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/admin/user-list";
    }

    @GetMapping("/admin/user-create")
    public String createUserForm(User user){
        return "/admin/user-create";
    }

    @PostMapping("/admin/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/admin/user-update";
    }

    @PostMapping("/admin/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/admin")
    public String admin(){
        return "/admin/admin";
    }
}

