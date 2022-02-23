package com.sesp.patrimonio.app.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sesp.patrimonio.app.models.ImageField;
import com.sesp.patrimonio.app.models.Patrimony;

import lombok.Data;

@Data
public class PatrimonyDTO implements Serializable {

    private String id;

    private String name;

    private String description;

    private String patrimonio;

    private String situation;

    private String setor;

    private List<ImageField> images;

    public PatrimonyDTO(){
        super();
    }

    public PatrimonyDTO(Patrimony obj){
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
        this.patrimonio = obj.getPatrimonio();
        this.situation = obj.getSituation();
        this.setor = obj.getSetor();
        this.images =  new ArrayList<>();
        this.images.addAll(obj.getImages());
    }
    
}
