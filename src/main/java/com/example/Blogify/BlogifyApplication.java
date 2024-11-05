package com.example.Blogify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BlogifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogifyApplication.class, args);
    }

}
