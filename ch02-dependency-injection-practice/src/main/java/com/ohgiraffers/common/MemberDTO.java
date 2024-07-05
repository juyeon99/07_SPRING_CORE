package com.ohgiraffers.common;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String nickname;
}