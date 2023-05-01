package com.sportconnection.sccoreapi.config;

import com.sportconnection.sccoreapi.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper createUserMapper() {
        return new UserMapper();
    }

}
