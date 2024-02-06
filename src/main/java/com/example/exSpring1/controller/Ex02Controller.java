package com.example.exSpring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/ex02")
public class Ex02Controller {

    @Autowired
    private HttpSession session;

@GetMapping("/")
public String index() {

    return "exam02";
}

@PostMapping("/input-num")
public String inputNum(Integer num1, Integer num2) {
    

    session.setAttribute("num1", num1);
    session.setAttribute("num2", num2);
    // sum = num1 + num2;
    //  model.addAttribute("sum", sum);


    return "redirect:/ex02/toresult";
    // return "exam02-result";
}

@GetMapping("/toresult")
public String toResult() {
    return "exam02-result";
}


@GetMapping("/toresult2")
public String toResult2() {
    return "exam02-result2";
}



    

    

}
