package com.ohgiraffers.practice01.field;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice01.field");
        MemberController memberController = context.getBean(MemberController.class);

        Map<Long, MemberDTO> memberMap = memberController.selectMember();
        System.out.println(memberMap);
    }
}
