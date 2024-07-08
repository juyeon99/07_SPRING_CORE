package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // Pointcut, Advice
    /*
    * @Pointcut: 여러 Join Point를 매치하기 위한 표현식
    *            execution([수식어] 리턴타입 [클래스이름].이름(param))
    *            수식어는 생략 가능(접근제한자 - public, private, protected, default)
    *            *Service.*(..):   parameter가 0개 이상인 모든 메소드
    *            *Service.*(*):    parameter가 1개인 모든 메소드
    *            *Service.*(*,..): parameter가 2개인 모든 메소드
    * */

    // * = 아무 리턴타입이나 가능
    // .*Service = 'Service'로 끝나는 모든 클래스 가능
    // .*(..) = 모든 메소드 가능, 모든 파라미터 가능
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")  // Join Point들을 집합시켜놓음
    public void logPointcut() {}

    /*
    * JoinPoint: Pointcut으로 패치한 실행 지점
    * JoinPoint 객체에서 현재 Join Point의 메소드명, 인수값 등의 정보 엑세스 가능
    * */
    @Before("logPointcut()")    // 코드 실행 전 Advice 동작
    public void logBefore(JoinPoint joinPoint){
        // 조인포인트에서 할 일. Advice
        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature(): " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0){    // parameter가 존재하면 출력
            System.out.println("Before joinPoint.getArgs()[0] (= 매개변수 값): " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        // 조인포인트에서 할 일. Advice
        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature(): " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0){    // parameter가 존재하면 출력
            System.out.println("After joinPoint.getArgs()[0] (= 매개변수 값): " + joinPoint.getArgs()[0]);
        }
    }

    // 리턴받은 값을 가공하는 형태로 사용
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturning result: " + result);
    }

    /*
    * AfterThrowing
    * => throwing 속성의 이름과 parameter의 이름이 동일해야 함
    * */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("AfterThrowing exception: " + exception);
    }

    /*
    * Around Advice
    * - 조인 포인트를 완전히 장악한다.
    * - 앞에서의 어드바이스 모두 around advice로 조합 가능
    * - AroundAdvice의 조인 포인트 parameter는 ProceedingJoinPoint로 고정되어 있기 때문에
    *   JoinPoint의 하위 인터페이스로 원본 조인 포인트의 진행 시점을 제어 할 수 있다.
    * - 조인 포인트 진행하는 호출을 잊는 경우가 많이 발생하기 때문에 최소한의 요건을 충족하면서도
    *   가장 기능이 약한 어드바이스를 쓰는게 바람직하다.
    * */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        // 사전 로직
        System.out.println("Around Before: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();    // 사전과 사후의 기준

        // 사후 로직
        System.out.println("Around After: " + joinPoint.getSignature().getName());

        return result;
    }
}
