package com.futurodev.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurodev.biblioteca.model.Autor;
import com.futurodev.biblioteca.repository.AutorRepository;
import com.futurodev.biblioteca.service.interfaces.AutorService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor salvar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    @Override
    public Autor atualizar(Autor autor) {
        Autor autorBuscado = buscar(autor.getId());
        if (autorBuscado!= null) {
            BeanUtils.copyProperties(autor, autorBuscado, "id");
            this.autorRepository.save(autor);
        }
        return null;
    }

    @Override
    public List<Autor> listar() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor buscar(Long id) {
        Optional<Autor> autorPesquisado = this.autorRepository.findById(id);
        if(autorPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi encontrado um autor com o id "+id);
            
        }

        return autorPesquisado.get();
    }

    @Override
    public void deletar(Long id) {
        this.autorRepository.deleteById(id);
    }
    
}
