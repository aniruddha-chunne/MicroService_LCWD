package com.lcwd.user.service.UserService;

import com.lcwd.user.service.UserService.external.services.RatingService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {



	public static void main(String[] args)
	{
		SpringApplication.run(UserServiceApplication.class, args);
		System.out.println("MicroService Project");
	}
}
