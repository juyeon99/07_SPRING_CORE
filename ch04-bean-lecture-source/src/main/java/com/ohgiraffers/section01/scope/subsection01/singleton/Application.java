package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /*
    * bean scope
    * 스프링 빈이 생성될 때 생기는 인스턴스의 범위를 의미
    * 스프링에서는 다양한 bean scope를 제공한다. default = singleton
    *
    * 1. singleton     하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용
    * 2. prototype     매번 새로운 인스턴스 생성
    * 3. request       HTTP 요청을 처리할 때마다 새로운 인스턴스 생성, 요청처리가 끝나면 인스턴스 폐기
    *                  웹 어플리케이션 컨텍스트에만 해당
    * 4. session       HTTP 세션 당 하나의 인스턴스 생성, 세션 종료 후 인스턴스 폐기
    *                  웹 어플리케이션 컨텍스트에만 해당
    * 5. globalSession 전역 세션 당 하나의 인스턴스 생성, 전역 세션 종료 후 인스턴스 폐기
    *                  포털 어플리케이션 컨텍스트에만 해당
     * */
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
        System.out.println("cart2에 담긴 물건: " + cart2.getItems()); // [Bread(super=Product(name=붕어빵, price=1000), bakedDate=2024-07-08), Beverage(super=Product(name=딸기우유, price=1500), capacity=500), Beverage(super=Product(name=지리산암반수, price=3000), capacity=500)]

        System.out.println("cart1의 hashCode: " + cart1.hashCode()); // 129153987
        System.out.println("cart2의 hashCode: " + cart2.hashCode()); // 129153987
        // Singleton이기 때문에 두 손님이 같은 카트에 물건을 담게 됨 (같은 객체를 가리킴)
    }
}
