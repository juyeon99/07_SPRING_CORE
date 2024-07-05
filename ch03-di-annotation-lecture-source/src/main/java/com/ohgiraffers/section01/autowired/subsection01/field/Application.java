package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceField", BookService.class);

        // 전체 도서 목록 조회
        List<BookDTO> books = bookService.selectAllBooks();
        for (BookDTO book : books) {
            System.out.println(book);
        }

        System.out.println("========== 단일 조회 ==========");
        // 도서번호로 검색 후 출력 확인
        System.out.println(bookService.selectBookBySequence(1));
        System.out.println(bookService.selectBookBySequence(2));
    }
}
