package com.company.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

    private Internet internet = new AccessToInternet();
    private static List<String> bannerUrl;
    static {
        bannerUrl = new ArrayList<>();
        bannerUrl.add("twitter.com");
        bannerUrl.add("facebook.com");
        bannerUrl.add("google.com");
    }
    @Override
    public void conectTo(String url) throws Exception {
        if (bannerUrl.contains(url)){
            throw new Exception("URL bloqueada - Acceso Denegado - Consulta con tu administrador");
        }
       internet.conectTo(url);
    }
}
