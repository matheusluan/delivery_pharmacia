package com.ifpr.delivery_pharmacia.controllers;


import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.ifpr.delivery_pharmacia.models.Venda;
import com.ifpr.delivery_pharmacia.models.Venda_receita;
import com.ifpr.delivery_pharmacia.repositories.VendaItemRepository;
import com.ifpr.delivery_pharmacia.repositories.VendaRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class VendaController {

    VendaRepository repository;
    VendaItemRepository venda_item_repository;

    static String diretorio_receitas = "src/main/resources/imagens/receitas/";

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

    @Transient
    @PostMapping("/venda/add_with_image")
    public Venda addVendaComImagem(@ModelAttribute Venda venda, @RequestParam("imagens_receitas") MultipartFile[] uploadingFiles){

        List<Venda_receita> receitas = new ArrayList<>();

        for(MultipartFile arquivo : uploadingFiles) {
            try {
                if(!arquivo.isEmpty()){
                    byte [] bytes = arquivo.getBytes();

                    String new_name =  RandomString.make(25)+"."+ FilenameUtils.getExtension(arquivo.getOriginalFilename());

                    Path caminho = Paths.get(diretorio_receitas+new_name);

                    Files.write(caminho, bytes);

                    Venda_receita receita = new Venda_receita();
                    receita.setArquivo(new_name);

                    receitas.add(receita);

                }
            }catch (IOException e){
                throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
            }
        }

        venda.setReceitas(receitas);
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
