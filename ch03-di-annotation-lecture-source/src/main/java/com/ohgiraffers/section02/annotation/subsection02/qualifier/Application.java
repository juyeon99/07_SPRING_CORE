package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        PokemonService pokemonService = context.getBean("pokemonServiceQualifier",PokemonService.class);

        // 1. Field 주입 방식 => 피카츄 백만볼트⚡
        // 2. Constructor 주입 방식 => 꼬부기 물대포 발사🌊
        pokemonService.pokemonAttack();
    }
}
