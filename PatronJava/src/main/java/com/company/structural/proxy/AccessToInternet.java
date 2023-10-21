package com.company.structural.proxy;

public class AccessToInternet implements Internet{

    @Override
    public void conectTo(String url) throws Exception {
        System.out.println("Conectando a : " + url);
    }
}
