package com.ohgiraffers.common;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private int sequence;               // 회원번호
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;    // 개인계좌
}
