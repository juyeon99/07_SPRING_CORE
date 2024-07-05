package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean("account")
    public Account accountGenerator(){
        return new PersonalAccount(20, "110-234-56789");
    }

    @Bean("member")
    public MemberDTO memberGenerator(){
        // MemberDTO generator를 통해 Account를 생성하는 메소드를 호출 리턴값을 전달하여 bean을 조립
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong123@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
