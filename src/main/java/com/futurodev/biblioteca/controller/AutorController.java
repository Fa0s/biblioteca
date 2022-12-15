package com.futurodev.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurodev.biblioteca.model.Autor;
import com.futurodev.biblioteca.service.interfaces.AutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody @Valid Autor autor) {
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.autorService
        .salvar(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        return ResponseEntity.ok(this.autorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.autorService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizar(@RequestBody @Valid Autor autor) {
        return ResponseEntity.ok(this.autorService.atualizar(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        this.autorService.deletar(id);
        return ResponseEntity
        .ok()
        .build();
    }

}
