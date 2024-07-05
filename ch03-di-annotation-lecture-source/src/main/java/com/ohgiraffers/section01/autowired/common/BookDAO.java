package com.ohgiraffers.section01.autowired.common;

import java.util.List;

public interface BookDAO {
    List<BookDTO> selectBookList();                // 도서 목록 전체 조회
    BookDTO selectBookBySequence(int sequence);    // 도서 번호로 도서 조회
}
