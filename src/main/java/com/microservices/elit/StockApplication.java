package com.microservices.elit;

import java.util.UUID;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableDiscoveryClient
@EnableHystrix
public class StockApplication {
	
	@Bean
	public org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClient forHystrixDashB(){
		return new org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClient(null);
	}
	
	@Bean
	  public Jackson2JsonMessageConverter messageConverter() {
	    return new Jackson2JsonMessageConverter();
	  }
/*	
	@LoadBalanced
	@HystrixCommand(commandKey = "home", fallbackMethod = "homeFallback")
	@RequestMapping("/")
	public Message home() {
		return new Message("Hello from Stock");
	}
	
	public Message homeFallback() {
		return null;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}
/*
class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
*/