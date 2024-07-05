package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        // expected single matching bean but found 3: charmander,pikachu,squirtle
        // 스프링 컨텍스트에 등록된 같은 타입의 bean이 3개나 있다는 뜻. 1개만 필요 => @Primary 이용
        PokemonService pokemonService = context.getBean("pokemonServicePrimary",PokemonService.class);
        pokemonService.pokemonAttack(); // 파이리 불꽃 공격🔥
    }
}
