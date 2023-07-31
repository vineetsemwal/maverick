package org.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewaydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaydemoApplication.class, args);
	}

}
