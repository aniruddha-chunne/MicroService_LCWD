package com.lcwd.user.service.UserService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig
{

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
