package com.esprit.ski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
@EntityScan

public class SkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkiApplication.class, args);
    }

}
