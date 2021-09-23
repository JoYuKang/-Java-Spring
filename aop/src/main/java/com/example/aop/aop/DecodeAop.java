package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect //Aop로 작동하기 위해서 사용
@Component //Spring으로 관리하기 위해서 사용
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))") //  com.example.aop.controller 하위에 전부 적용한다.
    private void cut() {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    public void enabledecode() {
    }

    @Before("cut() && enabledecode()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof User) {
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), StandardCharsets.UTF_8);
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enabledecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {

        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
            user.setEmail(base64Email);
        }

    }
}
