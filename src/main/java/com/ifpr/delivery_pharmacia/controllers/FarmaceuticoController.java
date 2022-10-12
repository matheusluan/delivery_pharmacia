package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.models.Cliente;
import com.ifpr.delivery_pharmacia.models.Endereco;
import com.ifpr.delivery_pharmacia.models.Farmaceutico;
import com.ifpr.delivery_pharmacia.repositories.EnderecoRepository;
import com.ifpr.delivery_pharmacia.repositories.FarmaceuticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FarmaceuticoController {

    FarmaceuticoRepository repository;

    @GetMapping("/farmaceutico")
    public List<Farmaceutico> getAllFarmaceutico(){
        return  repository.findAll();
    }

    @GetMapping("/farmaceutico/{id}")
    public Farmaceutico getFarmaceutico(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @PostMapping("/farmaceutico/add")
    public Farmaceutico addFarmaceutico(@RequestBody Farmaceutico farmaceutico ){
        return  repository.save(farmaceutico);
    }

    @PutMapping("/farmaceutico/edit")
    public Farmaceutico editFarmaceutico(@RequestBody Farmaceutico farmaceutico ){
        return repository.save(farmaceutico);
    }

    @DeleteMapping("farmaceutico/delete/{id}")
    public void deleteFarmaceutico(@PathVariable Long id){
        repository.deleteById(id);
    }

}
