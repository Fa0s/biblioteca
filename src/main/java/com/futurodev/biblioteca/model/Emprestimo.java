package com.futurodev.biblioteca.model;



import java.util.Date;
import java.util.concurrent.TimeUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Livro livro;

    private Date dataEmprestimo = new Date(System.currentTimeMillis());

    private Date dataEntrega;

    private Double preco = 1.00;

    private Double valor;


    public static Long calculaDias(Date dataEmprestimo,Date dataEntrega, TimeUnit timeUnit) {
        Long dias = dataEmprestimo.getTime() - dataEntrega.getTime();
        return timeUnit.convert(dias, TimeUnit.MILLISECONDS);
    }


    public Double calculaValor(Double preco,Date dataEmprestimo,Date dataEntrega,Double valor) {
        valor = preco * calculaDias(dataEmprestimo, dataEntrega, null);
        return valor;
    }

    private Boolean devolvido;

}
