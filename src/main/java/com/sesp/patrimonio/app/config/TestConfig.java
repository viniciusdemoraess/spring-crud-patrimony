package com.sesp.patrimonio.app.config;

import com.sesp.patrimonio.app.services.DBService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TestConfig {
    
    private DBService dbService;

    @Bean
    public void instanciaBaseDeDados(){
        this.dbService.instanciaBaseDeDados();
    }
}
