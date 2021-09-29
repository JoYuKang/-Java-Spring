package com.example.interceptor.intceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        // uri는
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                        .query(request.getQueryString()).build().toUri();


        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        // 권한 확인
        if(hasAnnotation){
            String query = uri.getQuery();
            if (query.equals("name=steve")){
                return true;
            }
            throw new AuthException();
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        // resoruse, javascript, http
        if (handler instanceof ResourceHttpRequestHandler) { // 객체 타입을 확인하는 연산자
            return true;
        }
        //annotation 확인
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getMethodAnnotation(clazz) != null || handlerMethod.getBeanType().getAnnotation(clazz) != null) {
            //Auth annotation이 있으면 true 값 리턴
            return true;
        }
        // annotation이 없다면 false반환
        return false;
    }

}
