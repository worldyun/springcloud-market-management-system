package com.whpu.market.service.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.whpu.market"})
@EnableDiscoveryClient
public class ServiceBusinessMain {
    public static void main(String[] args) {
        SpringApplication.run(ServiceBusinessMain.class);
    }
}
