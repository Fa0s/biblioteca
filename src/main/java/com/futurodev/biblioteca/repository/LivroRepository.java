package com.futurodev.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurodev.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
