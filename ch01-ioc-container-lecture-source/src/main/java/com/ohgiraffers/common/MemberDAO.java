package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
* @Component
* - 처음 IOC 컨테이너가 동작 할 때 해당 어노테이션이
*   붙은 클래스들을 찾아서 Bean으로 등록하고 알아서 객체로 만들어준다.
* */
@Component
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap;

    // 의존성 주입
    public MemberDAO(){
        memberMap = new HashMap<Integer, MemberDTO>();
        memberMap.put(1, new MemberDTO(1,"user01","pass01","홍길동"));
        memberMap.put(2, new MemberDTO(2,"user02","pass02","유관순"));
    }

    // parameter로 전달받은 회원정보를 map에서 조회 후 회원 정보를 리턴하는 메소드
    public MemberDTO selectMember(int sequence){
        return memberMap.get(sequence);
    }

    // parameter로 전달받은 회원정보를 map에 추가하고 성공/실패 여부를 boolean으로 리턴하는 메소드
    public boolean insertMember(MemberDTO newMember){
        int before = memberMap.size();
        memberMap.put(newMember.getSequence(), newMember);
        int after = memberMap.size();

        return after > before;
    }
}
