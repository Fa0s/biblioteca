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

import com.futurodev.biblioteca.model.Livro;
import com.futurodev.biblioteca.service.interfaces.AutorService;
import com.futurodev.biblioteca.service.interfaces.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class Livrocontroller {
    
    @Autowired
    private LivroService livroService;

    @Autowired AutorService autorService;

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody @Valid Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.livroService.salvar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.ok(this.livroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
    return ResponseEntity.ok(this.livroService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@RequestBody Livro livro){
        return ResponseEntity.ok(this.livroService.atualizar(livro));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        this.livroService.deletar(id);
        return ResponseEntity
        .ok()
        .build();
    }

}
