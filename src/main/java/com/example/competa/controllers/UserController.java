package com.example.competa.controllers;

import com.example.competa.repo.CompetaRepository;
// import com.example.competa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping ("/user")  // переход на страницу
    public String user (Model model){
        return "user-profile";  // вызывается шаблон
    }

    @GetMapping ("/user/edit")  // переход на страницу
    public String userEdit (Model model){
        return "user-edit";  // вызывается шаблон
    }

}
