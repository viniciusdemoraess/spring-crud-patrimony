package com.sesp.patrimonio.app.services;

import java.util.Optional;

import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.repository.PatrimonyRepository;
import com.sesp.patrimonio.app.services.exceptions.ObjectNotFoundException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatrimonyService {

    private PatrimonyRepository patrimonioRepository;

    public Patrimony findById(Long id) {
        Optional<Patrimony> obj = patrimonioRepository.findById(id);
        return obj.orElseThrow( 
            () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Patrimony.class.getName())
            );
    }
    
}
