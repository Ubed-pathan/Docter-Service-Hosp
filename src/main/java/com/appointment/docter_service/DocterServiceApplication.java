package com.appointment.docter_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient // this is for eureka Enable service discovery for this application
@EnableFeignClients
public class DocterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocterServiceApplication.class, args);
	}

}


