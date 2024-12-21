package com.sda.mockapi.mock_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation enables component scanning
public class MockApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockApiApplication.class, args);
    }
}
