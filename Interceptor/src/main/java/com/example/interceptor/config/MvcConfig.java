package com.example.interceptor.config;

import com.example.interceptor.intceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor  // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
@Configuration              // @Autowired 어노테이션 없이도 의존성 주입이 가능
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                                //addPathPatterns 을 넣어주면 특정 주소에서만 작동한다.
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");


    }
}
