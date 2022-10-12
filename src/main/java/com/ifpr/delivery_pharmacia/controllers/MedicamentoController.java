package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.enums.MedicamentoTipo;
import com.ifpr.delivery_pharmacia.models.Medicamento;
import com.ifpr.delivery_pharmacia.repositories.MedicamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicamentoController {

    MedicamentoRepository repository;

    @GetMapping("/medicamento")
    public List<Medicamento> getAllMedicamentos(){
        return  repository.findAll();
    }

    @GetMapping("/medicamento/{id}")
    public Medicamento getMedicamento(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @GetMapping("/medicamento/tipo/{tipo}")
    public List<Medicamento> getMedicamentoByType(@PathVariable MedicamentoTipo tipo){
        return  repository.findByTipo(tipo);
    }

    @PostMapping("/medicamento/add")
    public Medicamento addMedicamento(@RequestBody Medicamento medicamento ){
        return  repository.save(medicamento);
    }

    @PutMapping("/medicamento/edit")
    public Medicamento editMedicamento(@RequestBody Medicamento medicamento ){
        return repository.save(medicamento);
    }

    @DeleteMapping("medicamento/delete/{id}")
    public void deleteMedicamento(@PathVariable Long id){
        repository.deleteById(id);
    }

}
