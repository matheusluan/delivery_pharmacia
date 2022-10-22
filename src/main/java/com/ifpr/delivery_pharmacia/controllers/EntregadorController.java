package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.models.Entregador;
import com.ifpr.delivery_pharmacia.repositories.EntregadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EntregadorController {

    EntregadorRepository repository;

    @GetMapping("/entregador")
    public List<Entregador> getAllEntregador(){
        return  repository.findAll();
    }

    @GetMapping("/entregador/{id}")
    public Entregador getEntregador(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @PostMapping("/entregador/add")
    public Entregador addEntregador(@RequestBody Entregador entregador ){
        return  repository.save(entregador);
    }

    @PutMapping("/entregador/edit")
    public Entregador editEntregador(@RequestBody Entregador entregador ){
        return repository.save(entregador);
    }

    @DeleteMapping("entregador/delete/{id}")
    public void deleteEntregador(@PathVariable Long id){
        repository.deleteById(id);
    }

}
