package com.example.til_spring.springioc;


public class Encoder {

    private IEncoder iEncoder;

    //  iEncoder을 외부에서 주입받음 DI
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String encode) {
        return iEncoder.encode(encode);
    }

}
