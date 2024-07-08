package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = (MemberService) context.getBean("memberService");

        System.out.println("========== selectAllMembers ==========");
        System.out.println(memberService.selectMembers());
        // ========== selectAllMembers ==========
        // Around Before: selectMembers
        // Before joinPoint.getTarget(): com.ohgiraffers.section01.aop.MemberService@5f20155b
        // Before joinPoint.getSignature(): Map com.ohgiraffers.section01.aop.MemberService.selectMembers()
        // 전체조회 - selectMembers() 메소드 실행
        // AfterReturning result: {1=MemberDTO(id=1, name=유관순), 2=MemberDTO(id=2, name=홍길동)}
        // After joinPoint.getTarget(): com.ohgiraffers.section01.aop.MemberService@5f20155b
        // After joinPoint.getSignature(): Map com.ohgiraffers.section01.aop.MemberService.selectMembers()
        // Around After: selectMembers
        // {1=MemberDTO(id=1, name=유관순), 2=MemberDTO(id=2, name=홍길동)}

        System.out.println("\n========== selectMemberById ==========");
//        System.out.println(memberService.selectMember(3L)); // exception 오류 => @AfterThrowing
        // AfterThrowing exception: java.lang.RuntimeException: 해당하는 id의 회원이 없습니다.

        System.out.println(memberService.selectMember(1L));
        // ========== selectMemberById ==========
        // Around Before: selectMember
        // Before joinPoint.getTarget(): com.ohgiraffers.section01.aop.MemberService@5f20155b
        // Before joinPoint.getSignature(): MemberDTO com.ohgiraffers.section01.aop.MemberService.selectMember(Long)
        // Before joinPoint.getArgs()[0] (= 매개변수 값): 1
        // 단일조회 - selectMember() 메소드 실행
        // AfterReturning result: MemberDTO(id=1, name=유관순)
        // After joinPoint.getTarget(): com.ohgiraffers.section01.aop.MemberService@5f20155b
        // After joinPoint.getSignature(): MemberDTO com.ohgiraffers.section01.aop.MemberService.selectMember(Long)
        // After joinPoint.getArgs()[0] (= 매개변수 값): 1
        // Around After: selectMember
        // MemberDTO(id=1, name=유관순)
    }
}
