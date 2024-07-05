package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean("member")
    public MemberDTO memberGenerator(){
//        return new MemberDTO(2L, "nickname2");

        MemberDTO member = new MemberDTO();
        member.setId(2L);
        member.setNickname("nickname2");

        return member;
    }

    @Bean("board")
    public BoardDTO boardGenerator(){
        BoardDTO board = new BoardDTO();
        board.setId(2L);
        board.setTitle("title2");
        board.setContent("content2");
        board.setWriter(memberGenerator());

        return board;
    }
}
