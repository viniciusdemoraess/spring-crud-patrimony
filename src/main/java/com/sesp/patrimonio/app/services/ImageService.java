package com.sesp.patrimonio.app.services;

import java.util.List;
import java.util.Optional;

import com.sesp.patrimonio.app.dtos.ImageDTO;
import com.sesp.patrimonio.app.models.ImageField;
import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.repository.ImageRepository;
import com.sesp.patrimonio.app.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    private PatrimonyService patrimonyService;

    public ImageField findById(String id) {
        Optional<ImageField> obj = imageRepository.findById(id);
        return obj.orElseThrow( 
            () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + ImageField.class.getName())
            );
    }

    public List<ImageField> findAll() {
        return imageRepository.findAll();
    }

    public ImageField create(String id_patri, ImageField obj){
        obj.setId(null);
        Patrimony patri = patrimonyService.findById(id_patri);
        obj.setPatrimony(patri);

        return imageRepository.save(obj);

    }

    public ImageField update(String id, ImageDTO objDto) {
        ImageField obj = findById(id);

        obj.setImageUrl(objDto.getImageURL());

        return imageRepository.save(obj) ;
    }

    public void delete(String id) {
        findById(id);
        imageRepository.deleteById(id);
    }
    
}
