package com.oracle.cloudnote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oracle.cloudnote.dao")
public class CloudnoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudnoteApplication.class, args);
    }
}
