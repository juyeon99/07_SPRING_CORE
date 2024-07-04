package com.ohgiraffers.practice03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;

// Bean 스캐닝의 범위를 com.ohgiraffers.practice03.annotationconfig 패키지로 설정한다.
@ComponentScan(basePackages = "com.ohgiraffers.practice03.annotationconfig")
public class ContextConfiguration {
}
