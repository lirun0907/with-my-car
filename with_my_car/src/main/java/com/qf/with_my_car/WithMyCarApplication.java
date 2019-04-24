package com.qf.with_my_car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qf.with_my_car.mapper")
public class WithMyCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(WithMyCarApplication.class, args);
    }

}
