package com.geek.conding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CondingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CondingApplication.class, args);
    }

}
