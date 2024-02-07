package com.example.exSpring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exSpring1.form.UserForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {

@GetMapping("/")
public String index(UserForm userForm) {

    return "exam04";
}

@PostMapping("/create")
public String create(@Validated UserForm userForm, BindingResult bindingResult,Model model) {


    if (bindingResult.hasErrors()) {
        
        return index(userForm);

    }

    return "redirect:/ex04/toresult";
}    


@GetMapping("/toresult")
public String toResult() {
    return "exam04-result";}


}
