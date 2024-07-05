package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 1.
//@ComponentScan(basePackages = "com.ohgiraffers")

// 2.
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = {
//        // excludeFilters: 특정조건에 맞는 클래스를 스캔에서 제외시킨다.
//                @ComponentScan.Filter(
//                        // 1. 타입으로 거를 필터 설정
////                        type = FilterType.ASSIGNABLE_TYPE,
////                        classes = {MemberDAO.class}
//
//                        // 2. 어노테이션 종류로 설정
////                        type = FilterType.ANNOTATION,
////                        classes = {org.springframework.stereotype.Component.class}
//                )
//        }
//)

// 3.
@ComponentScan(basePackages = "com.ohgiraffers",
        // 기본 어노테이션 (@Component, @Service, @Repository, @Controller)을 가진 클래스들이 자동으로 스캔된다. (기본값)
        useDefaultFilters = false,
        includeFilters = {
                // includeFilters: 기본필터 이외에 추가로 포함시키고 싶은 클래스를 스캔할 수 있다.
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {MemberDAO.class}
                )
        }
)
@Configuration("contextConfig")  // bean 이름 지정: @Configuration("contextConfig")
public class ContextConfiguration {

}
