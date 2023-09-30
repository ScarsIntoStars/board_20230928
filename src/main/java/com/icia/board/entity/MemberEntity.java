package com.icia.board.entity;

import com.icia.board.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_table")
@Setter(AccessLevel.PRIVATE)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String memberEmail;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 20)
    private String memberName;

    @Column(length=20)
    private String memberBirth;

    @Column(length=20)
    private String memberMobile;


    // DTO -> Entity
    public static MemberEntity saveToEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        return memberEntity;
    }

}
