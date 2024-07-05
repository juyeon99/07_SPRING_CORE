package com.ohgiraffers.common;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private MemberDTO writer;
}