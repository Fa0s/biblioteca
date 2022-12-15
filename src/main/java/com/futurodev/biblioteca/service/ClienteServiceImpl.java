package com.futurodev.biblioteca.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurodev.biblioteca.model.Cliente;
import com.futurodev.biblioteca.repository.ClienteRepository;
import com.futurodev.biblioteca.service.interfaces.Clienteservice;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements Clienteservice {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente salvar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        Cliente clienteBuscado = buscar(cliente.getId());
        if (Objects.nonNull(clienteBuscado)) {
            BeanUtils.copyProperties(cliente, clienteBuscado,"id");
            this.clienteRepository.save(clienteBuscado);
        }
            return null;
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente buscar(Long id) {
        Optional<Cliente> clientePesquisado = this.clienteRepository.findById(id);

        if(clientePesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi encontrado um cliente com o id "+id);

        }
        return clientePesquisado.get();
    }

    @Override
    public void deletar(Long id) {
        this.clienteRepository.deleteById(id);        
    }
    
}
