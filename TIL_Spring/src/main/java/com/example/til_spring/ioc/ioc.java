package com.example.til_spring.ioc;

public class ioc {
    public static void main(String[] args) {
        String url = "https://book.naver.com/category/index.nhn?cate_code=280010";
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println("------------------");
        System.out.println(result);
    }
}
