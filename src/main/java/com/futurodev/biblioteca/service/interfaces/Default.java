package com.futurodev.biblioteca.service.interfaces;

import java.util.List;

public interface Default<T> {

    T salvar(T object);
    T atualizar(T object);
    List<T> listar();
    T buscar(Long id);
    void deletar(Long id);

}
