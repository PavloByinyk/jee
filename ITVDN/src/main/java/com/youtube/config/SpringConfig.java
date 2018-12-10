package com.youtube.config;

import com.youtube.dao.TestUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public TestUser getTestuser(){
        return new TestUser("Jim");
    }
}
