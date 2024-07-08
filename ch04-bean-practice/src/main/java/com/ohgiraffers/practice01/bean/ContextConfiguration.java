package com.ohgiraffers.practice01.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
    public static Long SINGLETON_COUNT = 1L;
    public static Long PROTOTYPE_COUNT = 1L;

    /* 위의 정적 변수를 활용하여 빈 등록 코드 작성 */
    // 1. bean scope singleton 설정으로 SingletonBean 타입의 빈 등록
    @Bean
    @Scope("singleton")
    public SingletonBean singletonBean(){
        return new SingletonBean(SINGLETON_COUNT++ + "번째 메세지");
    }

    // 2. bean scope prototype 설정으로 PrototypeBean 타입의 빈 등록
    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean(){
        return new PrototypeBean(PROTOTYPE_COUNT++ + "번째 메세지");
    }

    // 3. initMethod, destoryMethod 설정과 함께 InitDestoryBean 타입의 빈 등록
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public InitDestoryBean initDestroy(){
        return new InitDestoryBean();
    }
}