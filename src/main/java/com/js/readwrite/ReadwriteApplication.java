package com.js.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.js.readwrite.mapper")
public class ReadwriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadwriteApplication.class, args);
    }

}
