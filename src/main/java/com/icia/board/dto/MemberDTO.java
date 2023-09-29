package com.icia.board.dto;

import lombok.Data;

@Data
public class MemberDTO {
    Long id;
    String memberEmail;
    String memberPassword;
    String memberBirthday;
    String memberMobile;
}
