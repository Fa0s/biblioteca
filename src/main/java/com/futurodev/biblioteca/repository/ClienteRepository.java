package com.futurodev.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurodev.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
