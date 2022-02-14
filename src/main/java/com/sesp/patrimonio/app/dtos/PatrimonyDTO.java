package com.sesp.patrimonio.app.dtos;

import java.io.Serializable;

import com.sesp.patrimonio.app.models.Patrimony;

import lombok.Data;

@Data
public class PatrimonyDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    public PatrimonyDTO(){
        super();
    }

    public PatrimonyDTO(Patrimony obj){
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }
    
}
