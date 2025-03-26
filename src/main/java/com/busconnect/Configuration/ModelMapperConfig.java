package com.busconnect.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // Ativa o mapeamento de campos diretamente
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); // Permite acesso a campos privados
        return modelMapper;
    }
}
