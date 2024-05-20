package co.software.proyebase.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class ModelMapperconfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
