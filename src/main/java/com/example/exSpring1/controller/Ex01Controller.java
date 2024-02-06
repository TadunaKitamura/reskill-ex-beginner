package com.example.exSpring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/ex01")
public class Ex01Controller {

@GetMapping("/")
public String index() {

    return "exam01";
}

@PostMapping("/input-name")
public String inputName(String name, Model model) {
    

    model.addAttribute("name", name);

    return "exam01-result";
}


    

    

}
