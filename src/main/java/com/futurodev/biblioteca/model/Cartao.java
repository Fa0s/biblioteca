package com.futurodev.biblioteca.model;

import com.futurodev.biblioteca.enums.TipoDeCartao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cartao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private TipoDeCartao tipoDeCartao;

    @Column(length = 16)
    private String numero;

    @PositiveOrZero
    private Double limite;

    private Double limiteDisponivel;

}
