package com.example.vaildation.advice;


import com.example.vaildation.dto.Error;
import com.example.vaildation.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice // RestController를 사용하기 때문에 RestControllerAdvice를 사용
// 만약 view를 사용한다면 ControllerAdvide를 사용
public class GlobalControllerAdvice {

    // 전체적인 예외를 전부 다룬다 But ApiController 안에서도 예외처리 가능
    // ApiController 안에서 예외 처리를 한다면 해당 에러는 GlobalControllerAdvice 처리 하지 않고
    // ApiController 안에 있는 예외 처리기로 작동한다.
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {// 예외 받기 e
        System.out.println(e.getClass().getName());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e , HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().stream().map(error -> (FieldError) error).forEach(fieldError -> {
            String fileName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String value = fieldError.getRejectedValue().toString();
            System.out.println("------------------------------");
            System.out.println(fileName);
            System.out.println(message);
            System.out.println(value);
            Error errorMessage = new Error();
            errorMessage.setField(fileName);
            errorMessage.setMessage(message);
            errorMessage.getInvalidValue(value);

            errorList.add(errorMessage);

        });

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");




        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        String fileName = e.getParameter().getParameterName();
        String message = e.getMessage();
        String value = Objects.requireNonNull(e.getValue()).toString();

        Error errorMessage = new Error();
        errorMessage.setField(fileName);
        errorMessage.setMessage(message);
        errorMessage.getInvalidValue(value);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
