package com.amul.farmer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AmulFarmerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmulFarmerServiceApplication.class, args);
	}

}
