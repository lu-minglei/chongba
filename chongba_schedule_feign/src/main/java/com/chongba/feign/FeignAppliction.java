package com.chongba.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by luMingLei
 */
// @SpringBootApplication
// @EnableFeignClients
public class FeignAppliction {
    
    public static void main(String[] args) {
        SpringApplication.run(FeignAppliction.class,args);
    }
}
