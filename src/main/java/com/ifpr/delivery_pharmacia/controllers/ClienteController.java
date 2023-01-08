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

    //Cadastra novo endereço no cliente
    @PostMapping("/cliente/endereco/{id}")
    public Cliente addEndereco(@RequestBody Endereco endereco, @PathVariable Long id ){

        endereco_repo.save(endereco);

        Cliente cliente = repository.findById(id).get();
        List<Endereco> listAdress = cliente.getEnderecos();
        listAdress.add(endereco);
        cliente.setEnderecos(listAdress);

        return  repository.save(cliente);
    }

    //Altera um endereço com base no id do endereço
    @PutMapping ("/endereco/{id}")
    public Endereco EditEndereco(@RequestBody Endereco endereco, @PathVariable Long id ){

        Endereco old_endereco = endereco_repo.findById(id).get();

        if (old_endereco != null) {

            //Só vai alterar oq foi mandado no body
            if (endereco.getDescricao() != null) {
                old_endereco.setDescricao(endereco.getDescricao());
            }

            if (endereco.getLogradouro() != null) {
                old_endereco.setLogradouro(endereco.getLogradouro());
            }

            if (endereco.getBairro() != null) {
                old_endereco.setBairro(endereco.getBairro());
            }

            if (endereco.getNumero() != null ) {
                old_endereco.setNumero(endereco.getNumero());
            }

            if (endereco.getCidade() != null) {
                old_endereco.setCidade(endereco.getCidade());
            }

            if (endereco.getEstado() != null) {
                old_endereco.setEstado(endereco.getEstado());
            }

            if (endereco.getCep() != null) {
                old_endereco.setCep(endereco.getCep());
            }

            if (endereco.getObservacao() != null) {
                old_endereco.setObservacao(endereco.getObservacao());
            }

            if (endereco.getPrincipal() != null) {
                old_endereco.setPrincipal(endereco.getPrincipal());
            }

            return  endereco_repo.save(old_endereco);
        }else{
            throw new RuntimeException("Endereço não encontrado com o id: " + id);
        }

    }

    @DeleteMapping("cliente/delete/{id}")
    public void deleteCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

}
