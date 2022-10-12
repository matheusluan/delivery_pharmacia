package com.ifpr.delivery_pharmacia.controllers;


import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.ifpr.delivery_pharmacia.models.Venda;
import com.ifpr.delivery_pharmacia.repositories.VendaItemRepository;
import com.ifpr.delivery_pharmacia.repositories.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@RestController
@AllArgsConstructor
public class VendaController {

    VendaRepository repository;
    VendaItemRepository venda_item_repository;

    @GetMapping("/venda")
    public List<Venda> getAllVenda(){
        return  repository.findAll();
    }

    @GetMapping("/venda/{id}")
    public Venda getVenda(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @Transient
    @PostMapping("/venda/add")
    public Venda addVenda(@RequestBody Venda venda ){
        return  repository.save(venda);
    }

    @PutMapping("/venda/edit")
    public Venda editVenda(@RequestBody Venda venda ){
        return repository.save(venda);
    }

    @PutMapping("/venda/edit_status/{id}/{status}")
    public Venda editVendaStatus(@PathVariable Long id, @PathVariable VendaStatus status ){

        Venda venda =  repository.findById(id).get();
        venda.setStatus(status);

        return repository.save(venda);
    }

    @DeleteMapping("venda/delete/{id}")
    public void deleteVenda(@PathVariable Long id){
        repository.deleteById(id);
    }

}
