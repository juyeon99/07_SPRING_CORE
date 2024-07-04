package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration { // 스프링 설정 클래스
    @Bean("board")
    public BoardDTO getBoard(){
        return new BoardDTO(2L,"title2","content2","홍길동");
    }
}
