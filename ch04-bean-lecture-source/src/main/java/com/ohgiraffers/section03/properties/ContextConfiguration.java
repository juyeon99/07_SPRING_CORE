package com.ohgiraffers.section03.properties;

import com.ohgiraffers.common.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
@PropertySource("section03/properties/product-info.properties")
public class ContextConfiguration {
    /*
    * place-holder(치환자) 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
    *
    * 주의: 공백을 사용하면 값을 읽어오지 못한다. ex) ${ bread.carpBread.name:팥붕어빵 } => X
    *
    * : 을 사용하면 값을 읽어오지 못하는 경우 사용할 대체값을 작성 할 수 있다.
    * */

    @Value("${bread.carpBread.name:팥붕어빵}")   // name을 찾아오지 못하면 팥붕어빵으로 지정
    private String carpBreadName;

    // 값은 여러번 불러와서 사용 가능
//    @Value("${bread.carpBread.name:슈크림붕어빵}")
//    private String carpBreadName2;

    @Value("${bread.carpBread.price:0}")    // price를 찾아오지 못하면 값을 0으로 지정
    private int carpBreadPrice;

    @Value("${beverage.milk.name:그냥우유}")
    private String milkName;

    @Value("${beverage.milk.price:0}")
    private int milkPrice;

    @Value("${beverage.milk.capacity:0}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName, carpBreadPrice, LocalDate.now());
    }

    @Bean
    public Product milk(){
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name:물}") String waterName,
                         @Value("${beverage.water.price:0}") int waterPrice,
                         @Value("${beverage.water.capacity:0}") int waterCapacity){
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
}
