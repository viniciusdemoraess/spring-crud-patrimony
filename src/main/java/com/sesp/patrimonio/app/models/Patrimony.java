package com.sesp.patrimonio.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Document(collection = "patrimonys")
public class Patrimony implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull(message="Campo Nome é requerido") 
    @Size(min= 4, max = 150, message="Campo NOME deve ter entre 4 e 150 Caracteres")
    private String name;

    @NotNull(message="Campo Descrição é requerido") 
    @Size(min= 10, max = 150, message="Campo DESCRICAO deve ter entre 25 e 150 Caracteres")
    private String description;

    @NotNull(message="Campo PATRIMONIO é requerido") 
    @Size(min= 5, max = 20, message="Campo PATRIMONIO deve ter entre 5 e 25 Caracteres")
    private String patrimonio;

    @NotNull(message="Campo SITUACAO é requerido") 
    @Size(min= 4, max = 20, message="Campo SITUACAO deve ter entre 5 e 20 Caracteres")
    private String situation;

    @NotNull(message="Campo SETOR é requerido") 
    @Size(min= 2, max = 20, message="Campo SETOR deve ter entre 5 e 20 Caracteres")
    private String setor;

    private List<ImageField> images = new ArrayList<>();

}
