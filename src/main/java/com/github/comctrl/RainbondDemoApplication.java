package com.github.comctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class RainbondDemoApplication {

    @Value("${user.name}")
    private String username = "abc";

    public static void main(String[] args) {
        SpringApplication.run(RainbondDemoApplication.class, args);
    }

    @GetMapping("hi")
    public String hi(HttpServletRequest request){
        return "hi  " + request.getLocalAddr();
    }

    @GetMapping("hello")
    public String hello(){
        return "hello " + username;
    }
}
