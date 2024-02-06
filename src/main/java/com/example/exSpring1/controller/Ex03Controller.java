package com.example.exSpring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletContext;



@Controller
@RequestMapping("/ex03")
public class Ex03Controller {

    @Autowired
    private ServletContext application;

@GetMapping("/")
public String index() {

    return "exam03";
}

@PostMapping("/input-item")
public String inputNum(Integer item1, Integer item2, Integer item3, Integer sum) {
    
    application.setAttribute("item1", item1);
    application.setAttribute("item2", item2);
    application.setAttribute("item3", item3);
    sum = (item1 + item2 + item3);
    application.setAttribute("sum", sum);
    return "exam03-result";
}    

}
