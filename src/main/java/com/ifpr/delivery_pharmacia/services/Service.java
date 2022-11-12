package com.ifpr.delivery_pharmacia.services;

import com.ifpr.delivery_pharmacia.models.*;
import com.ifpr.delivery_pharmacia.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
public class Service {

    ClienteRepository pessoa_repository;
    FarmaceuticoRepository farmaceutico_repository;
    ProdutoRepository medicamento_repository;

    VendaRepository venda_repository;

    EnderecoRepository endereco_repository;
    CategoriaRepository categoria_repository;

    @PostMapping("/adicionar")
    public void getAllPerson(){


        //Categoria
        Categoria categoria_1 = new Categoria();
        categoria_1.setDescricao("Higiene");

        Categoria categoria_2 = new Categoria();
        categoria_2.setDescricao("Antibiotico");

        Categoria categoria_3 = new Categoria();
        categoria_3.setDescricao("Injetavel");

        Categoria categoria_4 = new Categoria();
        categoria_4.setDescricao("Bebês");

        Categoria categoria_5 = new Categoria();
        categoria_5.setDescricao("Analgésicos");

        Categoria categoria_6 = new Categoria();
        categoria_6.setDescricao("Descongestionante");

        Categoria categoria_7 = new Categoria();
        categoria_7.setDescricao("Pomadas");

        categoria_repository.save(categoria_1);
        categoria_repository.save(categoria_2);
        categoria_repository.save(categoria_3);
        categoria_repository.save(categoria_4);
        categoria_repository.save(categoria_5);
        categoria_repository.save(categoria_6);
        categoria_repository.save(categoria_7);

        //Endereço
        Endereco end_1 = new Endereco();
        end_1.setDescricao("Casa");
        end_1.setBairro("Tres Lagoa");
        end_1.setEstado("PR");
        end_1.setCidade("Foz do Iguaçu");
        end_1.setLogradouro("Cesar Garcia da Rocha");
        end_1.setNumero("515151");
        end_1.setCep("85802702");
        endereco_repository.save(end_1);

        //Adiciona as pessoas
        Cliente cliente_1 = new Cliente();
        cliente_1.setNome("Matheus Luan");
        cliente_1.setCelular("45 9999999");
        cliente_1.setLogin("matheus123");
        cliente_1.setSenha("123");

        List<Endereco> enderecos = new ArrayList<>();

        enderecos.add(end_1);
        cliente_1.setEnderecos(enderecos);

        Farmaceutico farmaceutico_1 = new Farmaceutico();
        farmaceutico_1.setNome("Vinicius");
        farmaceutico_1.setCrf("1515-15");
        farmaceutico_1.setTelefone("45 9999999");
        farmaceutico_1.setLogin("vini123");
        farmaceutico_1.setSenha("123");


        pessoa_repository.save(cliente_1);
        farmaceutico_repository.save(farmaceutico_1);

        //Adiciona as medicamento
        Produto produto_1 = new Produto();
        produto_1.setNome("Neosoro");
        produto_1.setValor_unitario(5.00F);
        produto_1.setConteudo("30 ml");
        produto_1.setUso("Uso Adulto");
        produto_1.setFabricante("NeoQuimica");
        produto_1.setFormula("cloridrato de nafazolina 0,5mg/mL");
        produto_1.setCategoria(categoria_6);
        produto_1.setImagem("1_9rEGDbSSZ23MNFV5JSEOVQCVF.png");
        produto_1.setPrecisa_receita(false);
        produto_1.setDescricao("Medicamento para descongestionamento nasal.");

        Produto produto_2 = new Produto();
        produto_2.setNome("Aspirina");
        produto_2.setValor_unitario(2.00F);
        produto_2.setCategoria(categoria_5);
        produto_2.setPrecisa_receita(false);
        produto_2.setDescricao("Medicamento para alívio de dor de cabeça.");

        Produto produto_3 = new Produto();
        produto_3.setNome("Hastes Flexiveis");
        produto_3.setValor_unitario(11.00F);
        produto_3.setFabricante("Cotonete");
        produto_3.setUso("Uso adulto e infantil");
        produto_3.setImagem("3_UyV0NIKde0vftivBf5sVuB5dN.jpg");
        produto_3.setCategoria(categoria_1);
        produto_3.setPrecisa_receita(false);
        produto_3.setDescricao("Medicamento para limpar o ouvido.");

        Produto produto_4 = new Produto();
        produto_4.setNome("Dorflex");
        produto_4.setValor_unitario(15.00F);
        produto_4.setConteudo("36 comprimidos");
        produto_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_4.setCategoria(categoria_5);
        produto_4.setPrecisa_receita(false);
        produto_4.setDescricao("Medicamento para dor no corpo em geral.");


        medicamento_repository.save(produto_1);
        medicamento_repository.save(produto_2);
        medicamento_repository.save(produto_3);
        medicamento_repository.save(produto_4);

    }

}
