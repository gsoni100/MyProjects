package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class EurekaClientApplication {

    @Value("${message:Hello default}")
    private String message;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello from EurekaClient! : "+this.message+" : Done ";
    }
    
    
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
	
}
