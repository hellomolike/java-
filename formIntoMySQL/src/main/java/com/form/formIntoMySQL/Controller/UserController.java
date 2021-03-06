package com.form.formIntoMySQL.Controller;


import com.form.formIntoMySQL.entity.User;
import com.form.formIntoMySQL.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute User user) {

        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setGender(user.getGender());
        newUser.setEmail(user.getEmail());
        newUser.setCity(user.getCity());
        userRepository.save(user);

        return "result";

    }

    @GetMapping("/all")
    public String getMessage(Model model) {

        Iterable<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        return "all";
    }

}

