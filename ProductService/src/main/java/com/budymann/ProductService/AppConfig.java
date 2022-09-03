package com.budymann.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelmapper(){
        var modelMapper = new ModelMapper();
        return modelMapper;
    }
}
