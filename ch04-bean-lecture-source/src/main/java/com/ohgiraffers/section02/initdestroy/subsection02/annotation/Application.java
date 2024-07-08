package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import com.ohgiraffers.common.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);    // 사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);
        System.out.println("cart1에 담긴 물건: " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart2에 담긴 물건: " + cart2.getItems());

        ((AnnotationConfigApplicationContext) context).close();     // 사장님이 가게 문을 닫았습니다. 내일 다시 오세요.
    }
}
