package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class ContextConfiguration {
    @Bean
    public Product carpBread(){
        return new Bread("붕어빵", 1000, LocalDate.now());
    }

    @Bean
    public Product milk(){
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype") // 호출할 때마다 객체 새로 생성
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")  // Owner.openShop(), Owner.closeShop()
    public Owner owner(){
        return new Owner();
    }
}
