package com.company.singleton;

public class SocketClient {
    //자기자체를 객체로 가지고 있어햐한다.
    private static SocketClient socketClient = null;

    // 싱글톤은 기본 생성자를 통해서 생성 x
    private SocketClient() {

    }

    public static SocketClient getInstance() {
        // 자신이 가진 객체가 null이면 객체를 생성해준다.
        // 싱글톤을 유지하기 위해서 사용
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void  connect(){
        System.out.println("connect");
    }

}
