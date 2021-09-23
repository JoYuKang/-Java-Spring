package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

@Aspect
@Component // bean과 Component의 차이
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") //  com.example.aop.controller 하위에 전부 적용한다.
    private void cut() {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    public void enableTimer() {
    }

    //before 와 after은 시간을 공유할 수 없다.
    // 이때 around를 사용

    @Around("cut() && enableTimer()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //메소드 실행
        Object result = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        return "total time : " + stopWatch.getTotalTimeSeconds();
    }


}
