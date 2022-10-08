package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.enums.PessoaTipo;
import com.ifpr.delivery_pharmacia.models.Pessoa;
import com.ifpr.delivery_pharmacia.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PessoaController {

    PessoaRepository repository;

    @GetMapping("/pessoa/")
    public List<Pessoa> getAllPerson(){
        return  repository.findAll();
    }

    @GetMapping("/pessoa/tipo/{tipo}")
    public List<Pessoa> getPersonByType(@PathVariable PessoaTipo tipo){
        return  repository.findByTipo(tipo);
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa getPerson(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @PostMapping("/pessoa/add")
    public Pessoa addPerson(@RequestBody Pessoa person ){
        return  repository.save(person);
    }

    @PutMapping("/pessoa/edit/")
    public Pessoa editPerson(@RequestBody Pessoa person ){
        return repository.save(person);
    }

    @DeleteMapping("pessoa/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        repository.deleteById(id);
    }

}
