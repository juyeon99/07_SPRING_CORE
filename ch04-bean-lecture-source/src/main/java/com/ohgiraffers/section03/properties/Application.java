package com.ohgiraffers.section03.properties;

import com.ohgiraffers.common.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Product.class);
        System.out.println("carpBread = " + carpBread); // carpBread = Bread(super=Product(name=붕어빵, price=1000), bakedDate=2024-07-08)

        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
        cart.addItem(carpBread);
        cart.addItem(milk);
        cart.addItem(water);

        System.out.println("cart에 담긴 상품들= " + cart.getItems()); // [Bread(super=Product(name=붕어빵, price=1000), bakedDate=2024-07-08), Beverage(super=Product(name=딸기우유, price=1500), capacity=500), Beverage(super=Product(name=지리산암반수, price=3000), capacity=500)]
    }
}
