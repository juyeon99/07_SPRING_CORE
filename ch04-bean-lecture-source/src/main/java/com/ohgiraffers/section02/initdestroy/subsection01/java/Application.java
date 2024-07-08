package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /*
        * Bean이 생성될 때 동작하는 init()과 사라질 때 동작하는 destroy()로 bean의 생성과 소멸이 언제 일어나는지 확인
        * */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);    // 사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);
        System.out.println("cart1에 담긴 물건: " + cart1.getItems());    // [Bread(super=Product(name=붕어빵, price=1000), bakedDate=2024-07-08), Beverage(super=Product(name=딸기우유, price=1500), capacity=500)]

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart2에 담긴 물건: " + cart2.getItems());    // [Beverage(super=Product(name=지리산암반수, price=3000), capacity=500)]

        // destroy 메소드 작동을 확인하기 위해 강제로 context 종료 (잘 쓰이진 않음)
        // 실제로는 컨테이너가 종료될 때 bean이 소멸하거나 메모리에서 가비지 컬렉터가 해당 빈을 메모리에서 지울 때 동작
        ((AnnotationConfigApplicationContext) context).close();     // 사장님이 가게 문을 닫았습니다. 내일 다시 오세요.
    }
}
