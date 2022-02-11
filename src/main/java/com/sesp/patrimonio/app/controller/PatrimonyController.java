package com.sesp.patrimonio.app.controller;

import java.util.List;

import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.repository.PatrimonyRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/patrimony")
@AllArgsConstructor
public class PatrimonyController {

    private final PatrimonyRepository patrimonyRepository; 

    @GetMapping
    public List<Patrimony> list(){
        return patrimonyRepository.findAll() ;
    }

    @Bean
    CommandLineRunner initDatabase(PatrimonyRepository patrimonyRepository){
        return args -> {
            patrimonyRepository.deleteAll();

            Patrimony p = new Patrimony();
            p.setDescription("Hello World");
            p.setPatrimonio("Banana");
            p.setSituation("World");
            p.setValue("Value mui alto");


            patrimonyRepository.save(p);
        };
    }
    
}
