package com.ms2.sdaproject1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// tworzymy klasę która zawiera "listę/zbiór" klas które można wstrzykiwać gdzie indziej
@Configuration
public class AppConfig {
    @Bean
    public MovieRepository movieRepository(){
        return new MovieRepository();
    }
}
