package ru.romankuznetsov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductCloudApp.class, args);
    }
}
