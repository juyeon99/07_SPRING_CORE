package com.ohgiraffers.practice03.annotationconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        BoardDAO boardDAO = context.getBean("boardDAO", BoardDAO.class);

        System.out.println(boardDAO.selectBoard(1L));
        boardDAO.insertBoard(new BoardDTO(3L,"title3","content3","writer3"));
        System.out.println(boardDAO.selectBoard(3L));
    }
}
