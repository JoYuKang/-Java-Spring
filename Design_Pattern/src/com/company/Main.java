package com.company;

import com.company.adapter.*;
import com.company.aop.AopBrowser;
import com.company.decorator.*;
import com.company.facade.Ftp;
import com.company.facade.Reader;
import com.company.facade.SftpClient;
import com.company.facade.Writer;
import com.company.observer.Button;
import com.company.observer.IButtonListener;
import com.company.proxy.Browser;
import com.company.proxy.BrowserProxy;
import com.company.proxy.IBrowser;
import com.company.singleton.SocketClient;
import com.company.singleton.exampleA;
import com.company.singleton.exampleB;
import com.company.strategy.*;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
/*      singleton
        exampleA examplea = new exampleA();
        exampleB exampleb = new exampleB();

        SocketClient aClient = examplea.getSocketClient();
        SocketClient bClient = exampleb.getSocketClient();

        System.out.println("객체 동일 확인");
        System.out.println(aClient.equals(bClient));
*/
        /* adapter
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        Cleaner cleaner = new Cleaner();

        Electronic110V adapterCl = new SocketAdapter(cleaner);
        connect(adapterCl);
        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapterair = new SocketAdapter(airConditioner);
        connect(adapterair);
        */
        /* proxyBrowser
        Browser browser = new Browser("www.naver.com");
        //browser.show();
//        browser.show();
//        browser.show();
        IBrowser proxbrowser = new BrowserProxy("www.daum.co.kr");
        proxbrowser.show();
        proxbrowser.show();
        */

        /* aop 사용 및 proxy 사용
        AtomicLong start = new AtomicLong();
        AtomicLong after = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    System.out.println("after");
                    long now = System.currentTimeMillis();
                    after.set(now - start.get());
                }
        );
        aopBrowser.show();

        System.out.println("loading time : "+after.get());

        aopBrowser.show();

        System.out.println("loading time : "+after.get());
        */

        /* decorator
        ICar audi = new Audi(2000);
        audi.showPrice();
        ICar audi3 =  new A3(audi,"A3");
        ICar audi4 =  new A4(audi,"A4");
        ICar audi5 =  new A5(audi,"A5");



        //a3
        audi3.showPrice();
        //a4
        audi4.showPrice();
        //a5
        audi5.showPrice();
        */
        /* observer
        Button button = new Button("버튼");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");
        */
        /*
        Ftp ftpClient = new Ftp("www.naver.com", 8080, "/home/etc");

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();


        reader.fileDisconnect();
        writer.fileDisconnect();
        */

        /*facade
        SftpClient sftpClient = new SftpClient("www.naver.com", 8080, "/home/etc", "text.tmp");

        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disconnect();
        */

        Encoder encoder = new Encoder();

        //base64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);


        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);


        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);



    }


    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }


    /*
    public static void connect(Electronic220V electronic220V){
        electronic220V.connect();
    }
    */

}
