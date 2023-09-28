package com.icia.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/memberPages/memberSave")
    public String memberSave(){
        return "memberPages/memberSave";
    }
}
