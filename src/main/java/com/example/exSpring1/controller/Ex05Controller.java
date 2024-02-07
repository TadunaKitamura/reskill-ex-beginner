package com.example.exSpring1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exSpring1.model.Member;
import com.example.exSpring1.repository.MemberRepository;

import jakarta.validation.constraints.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/ex05")
public class Ex05Controller {

@Autowired
private MemberRepository repository;

@GetMapping("/")
public String index(Model model) {

    return "exam05";
}
@PostMapping("/search")
public String search(String name, Model model) {
    List<Member> memberList = repository.findName(name);
    model.addAttribute("memberList", memberList);
    return "exam05-result";
}
}
