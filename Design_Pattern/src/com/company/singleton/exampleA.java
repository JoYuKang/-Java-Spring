package com.company.singleton;

public class exampleA {
    private SocketClient socketClient;

    public exampleA() {
        // 기본 생성자를 private으로 막아놔서 사용 불가능
        //this.socketClient = new SocketClient();
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
