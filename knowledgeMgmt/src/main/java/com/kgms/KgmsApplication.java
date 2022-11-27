package com.kgms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.kgms.mapper")
@EnableCaching
public class KgmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KgmsApplication.class, args);
    }
}
