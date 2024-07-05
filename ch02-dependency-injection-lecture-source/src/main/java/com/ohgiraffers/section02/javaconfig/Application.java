package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 자바 설정파일을 기반으로 ApplicationContext 객체 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO member = context.getBean(MemberDTO.class);
        System.out.println(member);
        // MemberDTO(sequence=1, name=홍길동, phone=010-1234-5678, email=hong123@gmail.com, personalAccount=PersonalAccount(bankCode=20, accNo=110-234-56780, balance=110-234-56780 계좌의 현재 잔액은 0원 입니다.))

        // MemberDTO의 PersonalAccount 객체 출력
        System.out.println(member.getPersonalAccount());
        // PersonalAccount(bankCode=20, accNo=110-234-56780, balance=110-234-56780 계좌의 현재 잔액은 0원 입니다.)

        System.out.println(member.getPersonalAccount().deposit(10000)); // 10000원 입금
        System.out.println(member.getPersonalAccount().getBalance());         // 잔액 출력
        System.out.println(member.getPersonalAccount().withdraw(5000)); // 5000원 출금
        System.out.println(member.getPersonalAccount().getBalance());         // 잔액 출력
    }
}
