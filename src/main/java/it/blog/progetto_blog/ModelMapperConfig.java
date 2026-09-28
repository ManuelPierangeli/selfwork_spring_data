package it.blog.progetto_blog;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper istanceModelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
