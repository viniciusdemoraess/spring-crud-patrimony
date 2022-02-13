package com.sesp.patrimonio.app.config;

import com.sesp.patrimonio.app.services.DBService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;

@Configuration
@Profile("dev")
@AllArgsConstructor
public class DevConfig {
    
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciaBaseDeDados(){
        if(strategy.equals("create")){
            this.dbService.instanciaBaseDeDados();
        }
        return false;
    }

}
