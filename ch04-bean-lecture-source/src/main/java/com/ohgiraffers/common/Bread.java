package com.ohgiraffers.common;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Bread extends Product{
    private LocalDate bakedDate;    // 생산 시간

    public Bread(String name, int price, LocalDate bakedDate) {
        super(name, price);     // parent class' constructor
        this.bakedDate = bakedDate;
    }

    //    @Override
//    public String toString() {
//        return "Bread{" +
//                super.toString() +        // callSuper = true (없으면 super 대신 this를 붙이므로 계속 자기 자신을 부르게 되어 overflow 발생)
//                "bakedDate=" + bakedDate +
//                '}';
//    }
}
