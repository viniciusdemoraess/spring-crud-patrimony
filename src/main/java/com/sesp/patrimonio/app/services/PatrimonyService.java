package com.sesp.patrimonio.app.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.sesp.patrimonio.app.dtos.PatrimonyDTO;
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

    public Patrimony update(Long id, PatrimonyDTO objDto) {
        Patrimony obj = findById(id);

        obj.setName(objDto.getName());
        obj.setDescription(objDto.getDescription());
        obj.setPatrimonio(objDto.getPatrimonio());
        obj.setSituation(objDto.getSituation());
        obj.setSetor(objDto.getSetor());

        return patrimonioRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        patrimonioRepository.deleteById(id);
    }

    public Patrimony findByPatrimonio(String patrimonio) {
        Patrimony obj = patrimonioRepository.findByPatrimonio(patrimonio);
        if (Objects.isNull(obj)){
            throw new ObjectNotFoundException("Patrimônio não encontrado!");
        }
        return obj;
        
    }   

    
}
