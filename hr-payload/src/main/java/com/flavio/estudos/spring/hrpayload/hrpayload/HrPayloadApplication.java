package com.flavio.estudos.spring.hrpayload.hrpayload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HrPayloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayloadApplication.class, args);
	}

}
