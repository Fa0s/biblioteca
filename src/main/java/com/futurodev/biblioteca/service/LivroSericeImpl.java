package com.futurodev.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurodev.biblioteca.model.Livro;
import com.futurodev.biblioteca.repository.LivroRepository;
import com.futurodev.biblioteca.service.interfaces.LivroService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroSericeImpl implements LivroService {
    
    @Autowired
    private LivroRepository livroRepository;


    @Override
    public Livro salvar(Livro livro) {
        return this.livroRepository.save(livro);

    }

    @Override
    public Livro atualizar(Livro livro) {
        Livro livroBuscado = buscar(livro.getId());
        if(Objects.nonNull(livro)){
            BeanUtils.copyProperties(livro, livroBuscado, "id");
            this.livroRepository.save(livroBuscado);
        }
        return null;
    }

    @Override
    public List<Livro> listar() {
        return this.livroRepository.findAll();
    }

    @Override
    public Livro buscar(Long id) {
        Optional<Livro> livroPesquisado = this.livroRepository.findById(id);
        if(livroPesquisado.isEmpty()){
            throw new EntityNotFoundException("não foi encontrado um livro com o id: "+id);
        }
        return livroPesquisado.get();
    }

    @Override
    public void deletar(Long id) {
        this.livroRepository.deleteById(id);
    }

}
