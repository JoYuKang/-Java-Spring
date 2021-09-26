package com.example.vaildation.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // RestController를 사용하기 때문에 RestControllerAdvice를 사용
                        // 만약 view를 사용한다면 ControllerAdvide를 사용
public class GlobalControllerAdvice {

    // 전체적인 예외를 전부 다룬다 But ApiController 안에서도 예외처리 가능
    // ApiController 안에서 예외 처리를 한다면 해당 에러는 GlobalControllerAdvice 처리 하지 않고
    // ApiController 안에 있는 예외 처리기로 작동한다.
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){// 예외 받기 e
        System.out.println(e.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }


}
