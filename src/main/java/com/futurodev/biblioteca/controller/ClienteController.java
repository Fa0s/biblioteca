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

import com.futurodev.biblioteca.model.Cliente;
import com.futurodev.biblioteca.service.interfaces.Clienteservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired Clienteservice clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.clienteService
        .salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(this.clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.clienteService.buscar(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualzar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.atualizar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.clienteService.deletar(id);
        return ResponseEntity
        .ok()
        .build();
    }

}