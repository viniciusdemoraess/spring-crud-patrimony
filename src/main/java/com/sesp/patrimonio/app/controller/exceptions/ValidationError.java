package com.sesp.patrimonio.app.controller.exceptions;

import java.util.List;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ValidationError extends StandardError{

    private List <FieldMessage> errors = new ArrayList<>();
    
    public ValidationError(){
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error){
        super(timestamp, status, error);
    }

    public void addError(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }



}
