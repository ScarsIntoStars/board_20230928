package com.icia.board.service;

import com.icia.board.dto.MemberDTO;
import com.icia.board.entity.MemberEntity;
import com.icia.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long save(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.saveToEntity(memberDTO);
        Long saveId = memberRepository.save(memberEntity).getId();
        return saveId;
    }
}
