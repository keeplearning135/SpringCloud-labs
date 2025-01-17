package com.keeplearning135.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class Application {

    //#http://localhost:9002/hystrix
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
