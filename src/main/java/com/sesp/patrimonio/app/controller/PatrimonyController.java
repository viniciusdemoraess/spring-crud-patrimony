package com.sesp.patrimonio.app.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;


import com.sesp.patrimonio.app.models.Patrimony;
import com.sesp.patrimonio.app.services.PatrimonyService;
import com.sesp.patrimonio.app.dtos.PatrimonyDTO;


import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/patrimony")
@AllArgsConstructor
public class PatrimonyController {

    private PatrimonyService patrimonyService;


    @GetMapping
    public ResponseEntity<List<PatrimonyDTO>> findAll(){
        List<Patrimony> list = patrimonyService.findAll();
        //Caso queira retornar o OBJ DTO 
        List<PatrimonyDTO> listDTO = list.stream().map(PatrimonyDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Patrimony> findById(@PathVariable String id) {
        Patrimony obj = patrimonyService.findById(id);
        return ResponseEntity.ok().body(obj);
    }  


    @GetMapping(value="/searchByPatrimony/{codigoBem}")
    public ResponseEntity<Patrimony> findByName(@PathVariable String codigoBem) {
        Patrimony obj = patrimonyService.findByPatrimonio(codigoBem);
        return ResponseEntity.ok().body(obj);
    }  


    @PostMapping
    public ResponseEntity<Patrimony> create(@Valid @RequestBody Patrimony obj) {
        obj = patrimonyService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<PatrimonyDTO> update(@PathVariable String id, @Valid @RequestBody PatrimonyDTO objDto) {
        Patrimony newObj = patrimonyService.update(id, objDto);
        return ResponseEntity.ok().body(new PatrimonyDTO(newObj));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        patrimonyService.delete(id);
        return ResponseEntity.noContent().build();

    }


}

//localhost:8080/categorias
