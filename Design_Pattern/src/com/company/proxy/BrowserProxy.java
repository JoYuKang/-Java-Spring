package com.company.proxy;

public class BrowserProxy implements IBrowser{
    private final String url;
    private Html html;

    public  BrowserProxy(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        if(html ==null){
            this.html = new Html(url);
            System.out.println("BrowserProxy Loading html from : " + url );
        }else{
            System.out.println("BrowserProxy use cache html : " + url );
        }

        return html;
    }
}
