package com.example.study.ex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 서블릿이 초기화될때 자동 호출되는 메섣,
        // 1. 서블릿의 초기화 작업
        System.out.println("init() 메소드 시작지점");
        //super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        // 입력
        // 처리
        // 출력
        System.out.println("service() 메소드 시작지점");
    }

    @Override
    public void destroy() {
        //super.destroy();
        // 서블릿이 메모리에서 제거될때 서블릿 컨테이너에 의해서 자동 호출
        System.out.println("destroy() 메소드 시작지점");
    }
}
