package com.example.til_spring;

import com.example.til_spring.springioc.ApplicationContextProvider;
import com.example.til_spring.springioc.Base64Encoder;
import com.example.til_spring.springioc.Encoder;
import com.example.til_spring.springioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class TilSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TilSpringApplication.class, args);
        //getContext로
        ApplicationContext context = ApplicationContextProvider.getContext();

        String url = "https://book.naver.com/category/index.nhn?cate_code=280010";
        // Encoder를 context.getBean을 통해서 가져온다. new 사용 x springcontext를 통해서 가져온다.
        // spring한테 권한을 넘김 제어의 역전
        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
        //bean을 클레스 이름으로 찾는다.
        // 기존 방식
        //Encoder encoder = new Encoder(base64Encoder);
        // bean
        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);

        System.out.println("------------------------------------------------------------------------------");
        // bean을 새롭게 주입
//        encoder.s etiEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);


    }

}

@Configuration //한개의 클래스에서 여러개의 bean을 등록할 때 사용
class config {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }


}