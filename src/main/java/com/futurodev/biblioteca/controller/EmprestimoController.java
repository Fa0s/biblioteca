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

import com.futurodev.biblioteca.model.Emprestimo;
import com.futurodev.biblioteca.service.interfaces.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;


    @PostMapping
    public ResponseEntity<Emprestimo> salvar(@RequestBody @Valid Emprestimo emprestimo) {
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.emprestimoService
        .salvar(emprestimo));
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listar() {
        return ResponseEntity.ok(this.emprestimoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.emprestimoService.buscar(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualzar(@RequestBody Emprestimo emprestimo){
        return ResponseEntity.ok(this.emprestimoService.atualizar(emprestimo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.emprestimoService.deletar(id);
        return ResponseEntity
        .ok()
        .build();
    }
    
}
