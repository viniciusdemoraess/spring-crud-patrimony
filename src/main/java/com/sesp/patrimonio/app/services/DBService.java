package com.sesp.patrimonio.app.services;

import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.repository.PatrimonyRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DBService {

    
    private final PatrimonyRepository patrimonyRepository; 

    public void instanciaBaseDeDados() {



            patrimonyRepository.deleteAll();

            Patrimony p = new Patrimony();
            p.setDescription("Hello World");
            p.setPatrimonio("Banana");
            p.setSituation("World");
            p.setValue("Value mui alto");


            patrimonyRepository.save(p);


    }
    
}
