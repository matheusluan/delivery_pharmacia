package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.models.Categoria;
import com.ifpr.delivery_pharmacia.models.Produto;
import com.ifpr.delivery_pharmacia.repositories.ProdutoRepository;
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
public class ProdutoController {

    ProdutoRepository repository;

    static String diretorio_produtos = "src/main/resources/imagens/produtos/";

    @GetMapping("/produto")
    public List<Produto> getAllMedicamentos(){
        return  repository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto getMedicamento(@PathVariable Long id){
        return  repository.findById(id).get();
    }

    @GetMapping("/produto/categoria/{id}")
    public List<Produto> getMedicamentoByType(@PathVariable Categoria id){
        return  repository.findByCategoria(id);
    }

    @PostMapping("/produto/add")
    public Produto addMedicamento(@RequestBody Produto produto){
        return  repository.save(produto);
    }

    @PostMapping("/produto/add_with_img")
    public Produto addMedicamentoComImagem
            (@ModelAttribute Produto produto,
             @RequestParam MultipartFile arquivo){

        repository.save(produto);

        try {
           if(!arquivo.isEmpty()){
               byte [] bytes = arquivo.getBytes();

               String new_name =  RandomString.make(25)+"."+FilenameUtils.getExtension(arquivo.getOriginalFilename());

               Path caminho = Paths.get(diretorio_produtos+ produto.getId()+"_"+new_name);
               Files.write(caminho, bytes);

               produto.setImagem(new_name);

               repository.save(produto);
           }
        }catch (IOException e){
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

        return produto;
    }

    @PostMapping("/produto/add_img/{id}")
    public Produto addImgMedicamento(@PathVariable Long id, @RequestParam MultipartFile arquivo ){

        Produto produto = repository.findById(id).get();

        if (produto.equals(null)){
            throw new RuntimeException("Produto com id " + id +" não encontado!");
        }

        try {
            if(!arquivo.isEmpty()){
                byte [] bytes = arquivo.getBytes();

                String new_name =  RandomString.make(25)+"."+FilenameUtils.getExtension(arquivo.getOriginalFilename());

                Path caminho = Paths.get(diretorio_produtos+ produto.getId()+"_"+new_name);
                Files.write(caminho, bytes);

                produto.setImagem(new_name);

                repository.save(produto);
            }
        }catch (IOException e){
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

        return produto;
    }


    @PutMapping("/produto/edit")
    public Produto editMedicamento(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @DeleteMapping("produto/delete/{id}")
    public void deleteMedicamento(@PathVariable Long id){
        repository.deleteById(id);
    }

}
