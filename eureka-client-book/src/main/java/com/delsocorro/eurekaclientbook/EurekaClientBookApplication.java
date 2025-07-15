package com.delsocorro.eurekaclientbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class EurekaClientBookApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(EurekaClientBookApplication.class, args);

        // Debug: Print Eureka server URL
        System.out.println("Eureka Server URL: " +
                ctx.getEnvironment().getProperty("eureka.client.service-url.defaultZone"));
    }

}
