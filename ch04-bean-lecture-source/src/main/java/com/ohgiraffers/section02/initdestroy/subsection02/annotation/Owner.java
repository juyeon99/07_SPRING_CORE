package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @PostConstruct  //  Owner 객체가 beanFactory에 등록될 때 동작 (= initMethod)
    public void openShop(){
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.");
    }

    @PreDestroy     //  Owner 객체가 beanFactory에서 삭제될 때 동작
    public void closeShop(){
        System.out.println("사장님이 가게 문을 닫았습니다. 내일 다시 오세요.");
    }
}
