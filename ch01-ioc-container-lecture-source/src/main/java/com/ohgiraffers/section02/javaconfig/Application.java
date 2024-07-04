package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class/*클래스의 메타정보*/);

        // 1. @Bean만 사용할 때
//        MemberDTO member1 = context.getBean("getMember",MemberDTO.class);

        // 2. @Bean("이름")을 이용해서 ID를 메소드명과 다르게 지정해 줄 수 있다.
        MemberDTO member2 = context.getBean("member",MemberDTO.class);
        System.out.println(member2);
    }
}
