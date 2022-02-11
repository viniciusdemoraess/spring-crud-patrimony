package com.sesp.patrimonio.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Patrimony implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long item;

    @Column(length = 200, nullable = false)
    private String description;

    @Column(length = 200, nullable = false)
    private String patrimonio;

    @Column(length = 20, nullable = false)
    private String situation;

    @Column(length = 50, nullable = false)
    private String value;
}
