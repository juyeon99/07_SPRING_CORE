package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    // 쇼핑 카트에 물건 담는 메소드
    public void addItem(Product item){
        items.add(item);
    }

    // 쇼핑 카트에 담긴 물건들을 리턴해주는 메소드
    public List<Product> getItems(){
        return items;
    }
}
