package com.futurodev.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurodev.biblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    
}
