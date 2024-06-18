package com.epam.Jenkinsfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Here we are!");
        SpringApplication.run(Main.class, args);
    }

    @RestController
    public class HelloController {
        @GetMapping("/")
        public String hello() {
            return "Hello, world!";
        }
    }
}
