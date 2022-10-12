package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.models.Cliente;
import com.ifpr.delivery_pharmacia.models.Endereco;
import com.ifpr.delivery_pharmacia.repositories.EnderecoRepository;
import com.ifpr.delivery_pharmacia.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController {

    ClienteRepository repository;
    EnderecoRepository endereco_repo;

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente(){
        return  repository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @PostMapping("/cliente/add")
    public Cliente addCliente(@RequestBody Cliente cliente ){
        return  repository.save(cliente);
    }

    @PutMapping("/cliente/edit")
    public Cliente editCliente(@RequestBody Cliente cliente ){
        return repository.save(cliente);
    }

    @PutMapping("/cliente/endereco/{id}")
    public Cliente addEndereco(@RequestBody Endereco endereco, @PathVariable Long id ){

        endereco_repo.save(endereco);

        Cliente cliente = repository.findById(id).get();
        List<Endereco> listAdress = cliente.getEnderecos();
        listAdress.add(endereco);
        cliente.setEnderecos(listAdress);

        return  repository.save(cliente);
    }

    @DeleteMapping("cliente/delete/{id}")
    public void deleteCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

}
