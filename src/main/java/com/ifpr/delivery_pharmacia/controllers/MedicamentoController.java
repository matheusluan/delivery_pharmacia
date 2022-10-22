package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.enums.MedicamentoTipo;
import com.ifpr.delivery_pharmacia.models.Medicamento;
import com.ifpr.delivery_pharmacia.repositories.MedicamentoRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@AllArgsConstructor
public class MedicamentoController {

    MedicamentoRepository repository;

    static String diretorio_produtos = "src/main/resources/imagens/produtos/";

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

    @PostMapping("/medicamento/add_with_img")
    public Medicamento addMedicamentoComImagem
            (@ModelAttribute Medicamento medicamento,
             @RequestParam MultipartFile arquivo){

        repository.save(medicamento);

        try {
           if(!arquivo.isEmpty()){
               byte [] bytes = arquivo.getBytes();

               String new_name =  RandomString.make(25)+"."+FilenameUtils.getExtension(arquivo.getOriginalFilename());

               Path caminho = Paths.get(diretorio_produtos+medicamento.getId()+"_"+new_name);
               Files.write(caminho, bytes);

               medicamento.setImagem(new_name);

               repository.save(medicamento);
           }
        }catch (IOException e){
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

        return medicamento;
    }

    @PostMapping("/medicamento/add_img/{id}")
    public Medicamento addImgMedicamento( @PathVariable Long id, @RequestParam MultipartFile arquivo ){

        Medicamento medicamento = repository.findById(id).get();

        if (medicamento.equals(null)){
            throw new RuntimeException("Medicamento com id " + id +" não encontado!");
        }

        try {
            if(!arquivo.isEmpty()){
                byte [] bytes = arquivo.getBytes();

                String new_name =  RandomString.make(25)+"."+FilenameUtils.getExtension(arquivo.getOriginalFilename());

                Path caminho = Paths.get(diretorio_produtos+medicamento.getId()+"_"+new_name);
                Files.write(caminho, bytes);

                medicamento.setImagem(new_name);

                repository.save(medicamento);
            }
        }catch (IOException e){
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

        return  medicamento;
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
