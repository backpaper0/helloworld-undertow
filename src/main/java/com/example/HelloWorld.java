package com.example;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import io.undertow.util.StatusCodes;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setHandler(exchange -> {
                    exchange.setStatusCode(StatusCodes.OK);
                    exchange.getRequestHeaders()
                            .put(Headers.CONTENT_TYPE, "text/plain; charset=UTF-8");
                    exchange.getResponseSender().send("Hello, world!");
                })
                .build()
                .start();
    }
}
