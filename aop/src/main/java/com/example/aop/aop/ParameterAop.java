package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //Aop로 작동하기 위해서 사용
@Component //Spring으로 관리하기 위해서 사용
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") //  com.example.aop.controller 하위에 전부 적용한다.
    private void cut() {

    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // method 타입을 받아오는 코드
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //System.out.println(method.getName());

//        for (Object obj : args) {
//            System.out.println("obj type : " + obj.getClass().getSimpleName());
//            System.out.println("obj value : " + obj);
//        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj : " + returnObj);
    }


}
