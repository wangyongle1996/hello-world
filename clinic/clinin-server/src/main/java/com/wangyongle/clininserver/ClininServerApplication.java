package com.wangyongle.clininserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wangyongle.clininserver.mapper")
public class ClininServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClininServerApplication.class, args);
    }

}
