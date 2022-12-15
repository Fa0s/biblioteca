package com.futurodev.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurodev.biblioteca.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    
}
