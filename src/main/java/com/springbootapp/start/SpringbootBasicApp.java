package com.springbootapp.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springbootapp"})
public class SpringbootBasicApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootBasicApp.class, args);
    }

}
