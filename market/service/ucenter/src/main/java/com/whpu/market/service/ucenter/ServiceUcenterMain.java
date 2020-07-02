package com.whpu.market.service.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.whpu.market"})
@EnableDiscoveryClient
public class ServiceUcenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUcenterMain.class);
    }
}
