package com.udf.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableAutoConfiguration
@EntityScan(basePackages = {"com.udf.tcc.models"})
@SpringBootApplication
public class UdfTccApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdfTccApplication.class, args);
	}
}
