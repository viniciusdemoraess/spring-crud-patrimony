package com.sesp.patrimonio.app.controller;

import java.util.List;

import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.repository.PatrimonyRepository;
import com.sesp.patrimonio.app.services.PatrimonyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/patrimony")
@AllArgsConstructor
public class PatrimonyController {

    private PatrimonyService patrimonyService;

    private final PatrimonyRepository patrimonyRepository; 

    @GetMapping
    public List<Patrimony> list(){
        return patrimonyRepository.findAll() ;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Patrimony> findById(@PathVariable Long id) {
        Patrimony obj = patrimonyService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}

//localhost:8080/categorias
