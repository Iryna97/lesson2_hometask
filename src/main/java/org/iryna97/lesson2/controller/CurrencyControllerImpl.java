package org.iryna97.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class CurrencyControllerImpl implements CurrencyController{

    private HttpClient client;
    private static HttpRequest usdRequest;
    private static HttpRequest eurRequest;
    private static HttpRequest plnRequest;

    @Autowired
    public CurrencyControllerImpl(HttpClient client,@Qualifier("requestUSD") HttpRequest usdRequest,@Qualifier("requestEUR") HttpRequest eurRequest,@Qualifier("requestPLN")  HttpRequest plnRequest) {
        this.client = client;
        this.usdRequest = usdRequest;
        this.eurRequest = eurRequest;
        this.plnRequest = plnRequest;
    }

    public static void makeRequest() throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.iryna97.lesson2.config");
        var client = context.getBean(HttpClient.class);
        var response1 =
                client.send(usdRequest,
                        HttpResponse.BodyHandlers.ofString());
        var response2 =
                client.send(eurRequest,
                        HttpResponse.BodyHandlers.ofString());
        var response3 =
                client.send(plnRequest,
                        HttpResponse.BodyHandlers.ofString());
        System.out.println(response1.body());
        System.out.println(response2.body());
        System.out.println(response3.body());

    }

}
