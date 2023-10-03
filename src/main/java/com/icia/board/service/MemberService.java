package com.icia.board.service;

import com.icia.board.dto.MemberDTO;
import com.icia.board.entity.MemberEntity;
import com.icia.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long memberSave(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.saveToEntity(memberDTO);
        Long saveId = memberRepository.save(memberEntity).getId();
        return saveId;
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList =memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity : memberEntityList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(memberEntity.getId());
            memberDTO.setMemberEmail(memberEntity.getMemberEmail());
            memberDTO.setMemberPassword(memberEntity.getMemberPassword());
            memberDTO.setMemberName(memberEntity.getMemberName());
            memberDTO.setMemberBirth(memberEntity.getMemberBirth());
            memberDTO.setMemberMobile(memberEntity.getMemberMobile());
            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }
}
