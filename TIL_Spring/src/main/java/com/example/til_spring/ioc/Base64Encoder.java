package com.example.til_spring.ioc;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encoder implements IEncoder{

    public String encode(String encode) {
        return Base64.getEncoder().encodeToString(encode.getBytes(StandardCharsets.UTF_8));
    }
    
}
