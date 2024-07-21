package com.keeplearning135.nacos.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("project.name", "com.keeplearning135.nacos.sentinel.demo");

        SpringApplication.run(Application.class, args);
    }

}
