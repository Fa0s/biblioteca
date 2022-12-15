package com.futurodev.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurodev.biblioteca.model.Cartao;
import com.futurodev.biblioteca.repository.CartaoRepository;
import com.futurodev.biblioteca.service.interfaces.CartaoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;


    @Override
    public Cartao salvar(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Cartao atualizar(Cartao cartao) {
        Cartao cartaoBuscado = buscar(cartao.getId());
        if (Objects.nonNull(cartaoBuscado)) {
            BeanUtils.copyProperties(cartao, cartaoBuscado,"id");
            this.cartaoRepository.save(cartaoBuscado);
        }
            return null;
    }

    @Override
    public List<Cartao> listar() {
        return this.cartaoRepository.findAll();
    }

    @Override
    public Cartao buscar(Long id) {
        Optional<Cartao> cartaoPesquisado = this.cartaoRepository.findById(id);

        if(cartaoPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi encontrado um cartao com o id "+id);

        }
        return cartaoPesquisado.get();
    }

    @Override
    public void deletar(Long id) {
        this.cartaoRepository.deleteById(id);        
    }
    
}
