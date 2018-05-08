package com.gl.sdp.pricecoin.bl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PriceCoinApplication {
    public static void main(String[] args) {
        SpringApplication.run(PriceCoinApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "<HTML><BODY><i>This is <b>SDP Price Coin</b> web application. Hello !!!</i></BODY></HTML>";
    }

}
