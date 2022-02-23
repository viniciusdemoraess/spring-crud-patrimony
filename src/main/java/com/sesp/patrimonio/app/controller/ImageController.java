package com.sesp.patrimonio.app.controller;

import com.sesp.patrimonio.app.models.ImageField;
import com.sesp.patrimonio.app.services.ImageService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.sesp.patrimonio.app.dtos.ImageDTO;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/image")
@AllArgsConstructor
public class ImageController {


    private ImageService service;
    // private final PatrimonyRepository patrimonyRepository; 

    @GetMapping
    public ResponseEntity<List<ImageDTO>> findAll(){
        List<ImageField> list = service.findAll();
        //Caso queira retornar o OBJ DTO
        List<ImageDTO> listDTO = list.stream().map(ImageDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ImageField> findById(@PathVariable String id) {
        ImageField obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }  

    @PostMapping
    public ResponseEntity<ImageField> create(@RequestParam(value="patrimony", defaultValue = "0") @Valid String id_patri,
        @Valid @RequestBody ImageField obj){

        ImageField newObj = service.create(id_patri, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/image/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    // @PostMapping
    // public ResponseEntity<ImageField> create(@Valid @RequestBody ImageField obj) {
    //     obj = service.create(obj);
    //     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    //     return ResponseEntity.created(uri).build();
    // }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<ImageDTO> update(@PathVariable String id, @Valid @RequestBody ImageDTO objDto) {
        ImageField newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new ImageDTO(newObj));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }



}
