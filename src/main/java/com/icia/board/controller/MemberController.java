package com.icia.board.controller;

import com.icia.board.dto.MemberDTO;
import com.icia.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println(memberDTO);
        memberService.memberSave(memberDTO);
        return  "index";
    }

    @GetMapping("/member/memberList")
    public String memberFindAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "/memberPages/memberList";
    }

    @GetMapping("/member/memberLogin")
    public String memberLogin(){
        return "/memberPages/memberLogin";
    }
}
