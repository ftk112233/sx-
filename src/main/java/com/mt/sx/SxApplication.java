package com.mt.sx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mt.sx.mapper")
public class SxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SxApplication.class, args);
    }

}
