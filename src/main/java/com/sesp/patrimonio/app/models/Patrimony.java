package com.sesp.patrimonio.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Patrimony implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    @NotNull(message="Campo Nome é requerido") 
    @Size(min= 4, max = 150, message="Campo NOME deve ter entre 4 e 150 Caracteres")
    private String name;

    @Column(length = 200, nullable = false)
    @NotNull(message="Campo Descrição é requerido") 
    @Size(min= 10, max = 150, message="Campo DESCRICAO deve ter entre 25 e 150 Caracteres")
    private String description;

    @Column(length = 200, nullable = false)
    @NotNull(message="Campo PATRIMONIO é requerido") 
    @Size(min= 5, max = 20, message="Campo PATRIMONIO deve ter entre 5 e 25 Caracteres")
    private String patrimonio;

    @Column(length = 20, nullable = false)
    @NotNull(message="Campo SITUACAO é requerido") 
    @Size(min= 4, max = 20, message="Campo SITUACAO deve ter entre 5 e 20 Caracteres")
    private String situation;

    @Column(length = 50, nullable = false)
    @NotNull(message="Campo SETOR é requerido") 
    @Size(min= 2, max = 20, message="Campo SETOR deve ter entre 5 e 20 Caracteres")
    private String setor;

    // @OneToMany(mappedBy="ImageUrl")
    // private List<Image> images = new ArrayList<>();
}
