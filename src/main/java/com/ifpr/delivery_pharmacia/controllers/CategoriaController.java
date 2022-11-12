package com.ifpr.delivery_pharmacia.controllers;



import com.ifpr.delivery_pharmacia.models.Categoria;
import com.ifpr.delivery_pharmacia.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoriaController {

    CategoriaRepository repository;

    @GetMapping("/categoria")
    public List<Categoria> getAllCategoria(){
        return  repository.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Categoria getCategoria(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @PostMapping("/categoria/add")
    public Categoria addCategoria(@RequestBody Categoria farmaceutico ){
        return  repository.save(farmaceutico);
    }

    @PutMapping("/categoria/edit")
    public Categoria editCategoria(@RequestBody Categoria farmaceutico ){
        return repository.save(farmaceutico);
    }

    @DeleteMapping("categoria/delete/{id}")
    public void deleteCategoria(@PathVariable Long id){
        repository.deleteById(id);
    }

}
