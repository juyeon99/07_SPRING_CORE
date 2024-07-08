package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName: beanNames){
            System.out.println("beanName: " + beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        // 첫번째 손님이 쇼핑 카트를 꺼냄
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        // 빵이랑 우유를 담음
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        // 담긴 내용 확인
        System.out.println("cart1에 담긴 물건: " + cart1.getItems()); // [Bread(super=Product(name=붕어빵, price=1000), bakedDate=2024-07-08), Beverage(super=Product(name=딸기우유, price=1500), capacity=500)]

        // 두번째 손님이 쇼핑 카트를 꺼냄
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

        // 물을 담음
        cart2.addItem(water);

        // 담긴 내용 확인
        System.out.println("cart2에 담긴 물건: " + cart2.getItems()); // [Beverage(super=Product(name=지리산암반수, price=3000), capacity=500)]

        System.out.println("cart1의 hashCode: " + cart1.hashCode()); // 1427381743
        System.out.println("cart2의 hashCode: " + cart2.hashCode()); // 1427646530
    }
}
