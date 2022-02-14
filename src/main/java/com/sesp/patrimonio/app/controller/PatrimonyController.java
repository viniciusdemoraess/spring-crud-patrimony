package com.sesp.patrimonio.app.controller;

import java.net.URI;
import java.util.List;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import com.sesp.patrimonio.app.models.Patrimony;
// import com.sesp.patrimonio.app.repository.PatrimonyRepository;
import com.sesp.patrimonio.app.services.PatrimonyService;
import com.sesp.patrimonio.app.dtos.PatrimonyDTO;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/patrimony")
@AllArgsConstructor
public class PatrimonyController {

    private PatrimonyService patrimonyService;

    // private final PatrimonyRepository patrimonyRepository; 

    @GetMapping
    public ResponseEntity<List<Patrimony>> findAll(){
        List<Patrimony> list = patrimonyService.findAll();
        //Caso queira retornar o OBJ DTO
       // List<PatrimonyDTO> listDTO = list.stream().map(obj -> new PatrimonyDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Patrimony> findById(@PathVariable Long id) {
        Patrimony obj = patrimonyService.findById(id);
        return ResponseEntity.ok().body(obj);
    }  

    @PostMapping
    public ResponseEntity<Patrimony> create(@RequestBody Patrimony obj) {
        obj = patrimonyService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Patrimony> update(@PathVariable Long id, @RequestBody  Patrimony obj) {
        Patrimony newObj = patrimonyService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Patrimony> delete(@PathVariable Long id){
        patrimonyService.delete(id);
        return ResponseEntity.noContent().build();

    }


}

//localhost:8080/categorias
