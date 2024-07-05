package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
* @Primary
* - @Autowired로 동일한 타입의 여러 bean을 찾게 되는 경우, 자동으로 연결될 우선시 할 타입 설정
* - 동일 타입의 클래스 중 한 개만 @Primary 어노테이션 사용 가능
* */
@Primary
@Component
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격🔥");
    }
}
