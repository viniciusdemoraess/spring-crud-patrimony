package com.sesp.patrimonio.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Patrimony implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    @NotEmpty  (message="Campo Nome é requerido")
   // @Length(max = 4, max = 150, message = "O Campo NOME deve ter entre 4 e 150 caracteres")
    private String name;

    @Column(length = 200, nullable = false)
    @NotEmpty  (message="Campo DESCRICAO é requerido")
    private String description;

    @Column(length = 200, nullable = false)
    @NotEmpty  (message="Campo PATRIMONIO é requerido")
    private String patrimonio;

    @Column(length = 20, nullable = false)
    @NotEmpty  (message="Campo SITUACAO é requerido")
    private String situation;

    // @Column(length = 50, nullable = false)
    // @NotEmpty  (message="Campo VALOR é requerido")
    // private String value;

    @Column(length = 50, nullable = false)
    @NotEmpty  (message="Campo SETOR é requerido")
    private String setor;
}
