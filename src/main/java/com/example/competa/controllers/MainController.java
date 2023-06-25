package com.example.competa.controllers;

import com.example.competa.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/") // - page Main controller
    public String home( Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/about") // - page About controller
    public String about( Model model) {
        model.addAttribute("title", "About");
        return "about";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }
}
