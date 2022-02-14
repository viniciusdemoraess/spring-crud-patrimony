package com.sesp.patrimonio.app.services;

import java.util.List;
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

    public List<Patrimony> findAll() {
        return patrimonioRepository.findAll();
    }

    public Patrimony create(Patrimony obj){
        obj.setId(null);
        return patrimonioRepository.save(obj);

    }

    public Patrimony update(Long id, Patrimony obj) {
        Patrimony newObj = findById(id);

        newObj.setName(obj.getName());
        newObj.setDescription(obj.getDescription());
        newObj.setPatrimonio(obj.getPatrimonio());
        newObj.setSituation(obj.getSituation());
        newObj.setValue(obj.getValue());
        newObj.setSetor(obj.getSetor());

        return patrimonioRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        patrimonioRepository.deleteById(id);
    }

    
}
