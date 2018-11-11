package com.polytech.bd.bd_client_for_hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@EntityScan("entity")
public class BdClientForHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdClientForHospitalApplication.class, args);
	}
}
