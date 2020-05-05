package com.example.itokeneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ItokenEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItokenEurekaApplication.class, args);
    }
}
