package com.etiya.customerservice;

import io.github.sabaurgup.annotations.EnableCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCore
@EnableFeignClients
public class CustomerserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerserviceApplication.class, args);
    }

}
