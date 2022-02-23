package com.sesp.patrimonio.app.models;

import java.io.Serializable;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.mongodb.core.mapping.DBRef;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Document
public class ImageField  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;

    @NotNull(message="Campo PATRIMONIO é requerido")
    @Size(min = 17, max = 350)
    private String imageUrl;

    // @JsonIgnore
    // @DBRef
    // @JsonIgnore
    // @ManyToMany
    @DBRef
    private Patrimony patrimony;

}

