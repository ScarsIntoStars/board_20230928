package com.icia.board.controller;

import com.icia.board.dto.MemberDTO;
import com.icia.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/memberSave")
    public String memberSave(){
        return "memberPages/memberSave";
    }

    @PostMapping("/member/memberSave")
    public String memberSave(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return  "/";
    }
}
