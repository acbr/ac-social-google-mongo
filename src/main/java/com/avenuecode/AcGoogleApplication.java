package com.avenuecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class AcGoogleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcGoogleApplication.class, args);
    }
}
