package com.futurodev.biblioteca.enums;

import lombok.Getter;

@Getter
public enum TipoDeCartao {
    
    DEBITO("Débito"),
    CREDITO("Crédito");

    private String tipoCartao;

    private TipoDeCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}



