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
        List<MemberDTO> memberDTOList = new ArrayList<>();                      // memberDTO를 담을 memberDTOList 생성
        for(MemberEntity memberEntity : memberEntityList) {
            MemberDTO memberDTO = new MemberDTO();                                  // memberDTO생성
            memberDTO.setId(memberEntity.getId());                              // entity를 dto로 넣음
            memberDTO.setMemberEmail(memberEntity.getMemberEmail());
            memberDTO.setMemberPassword(memberEntity.getMemberPassword());
            memberDTO.setMemberName(memberEntity.getMemberName());
            memberDTO.setMemberBirth(memberEntity.getMemberBirth());
            memberDTO.setMemberMobile(memberEntity.getMemberMobile());
            memberDTOList.add(memberDTO);                                       // dto를 list에 추가
        }
        return memberDTOList;
    }
}
