package com.example.til_spring.ioc;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    //  iEncoder을 외부에서 주입받음 DI
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String encode) {
        return iEncoder.encode(encode);
    }

}
