package com.futurodev.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurodev.biblioteca.model.Emprestimo;
import com.futurodev.biblioteca.repository.EmprestimoRepository;
import com.futurodev.biblioteca.service.interfaces.EmprestimoService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EmprestimoServiceImpl implements EmprestimoService{

    @Autowired
    private EmprestimoRepository emprestimoRepository;


    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        return this.emprestimoRepository.save(emprestimo);
    }

    @Override
    public Emprestimo atualizar(Emprestimo emprestimo) {
        Emprestimo emprestimoBuscado = buscar(emprestimo.getId());
        if (Objects.nonNull(emprestimoBuscado)) {
            BeanUtils.copyProperties(emprestimo, emprestimoBuscado,"id");
            this.emprestimoRepository.save(emprestimoBuscado);
        }
            return null;
    }

    @Override
    public List<Emprestimo> listar() {
        return this.emprestimoRepository.findAll();
    }

    @Override
    public Emprestimo buscar(Long id) {
        Optional<Emprestimo> emprestimoPesquisado = this.emprestimoRepository.findById(id);

        if(emprestimoPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi encontrado um Emprestimo com o id "+id);

        }
        return emprestimoPesquisado.get();
    }

    @Override
    public void deletar(Long id) {
        this.emprestimoRepository.deleteById(id);        
    }
    
}
