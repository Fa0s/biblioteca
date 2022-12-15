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

import com.futurodev.biblioteca.model.Cartao;
import com.futurodev.biblioteca.service.interfaces.CartaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
    
    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<Cartao> salvar(@RequestBody @Valid Cartao cartao) {
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.cartaoService
        .salvar(cartao));
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listar() {
        return ResponseEntity.ok(this.cartaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.cartaoService.buscar(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cartao> atualzar(@RequestBody Cartao cartao){
        return ResponseEntity.ok(this.cartaoService.atualizar(cartao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.cartaoService.deletar(id);
        return ResponseEntity
        .ok()
        .build();
    }

}
