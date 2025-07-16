package com.delsocorro.openfeignorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderServiceApplication.class, args);
    }

}
