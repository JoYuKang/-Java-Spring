package com.example.vaildation.validator;

import com.example.vaildation.annotaion.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth,String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        //초기화 패턴 지정
        this.pattern = constraintAnnotation.pattern();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // yyyyMM으로 값을 받아오고
        // foPatern에서는 yyyyMMdd로 받기 때문에 value 값에 + "01" 을 넣어준다.

        try {                                                                //지정된 패턴과 비교하여 확인
            LocalDate localDate = LocalDate.parse(value +"01", DateTimeFormatter.ofPattern(this.pattern));

        } catch (Exception e) {
            return false;
        }

        return true;

    }
}
