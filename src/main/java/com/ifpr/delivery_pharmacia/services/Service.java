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
        end_1.setBairro("Tres Lagoas");
        end_1.setEstado("PR");
        end_1.setCidade("Foz do Iguaçu");
        end_1.setLogradouro("Cesar Garcia da Rocha");
        end_1.setNumero("515151");
        end_1.setCep("85802702");
        end_1.setPrincipal(true);
        endereco_repository.save(end_1);

        //Endereço
        Endereco end_2 = new Endereco();
        end_2.setDescricao("Trabalho");
        end_2.setBairro("Centro");
        end_2.setEstado("PR");
        end_2.setCidade("Foz do Iguaçu");
        end_2.setLogradouro("Almirante Barroso");
        end_2.setNumero("4545");
        end_2.setCep("85851010");
        end_2.setPrincipal(true);
        endereco_repository.save(end_2);

        Endereco end_3 = new Endereco();
        end_3.setDescricao("Casa");
        end_3.setBairro("Porto Meira");
        end_3.setEstado("PR");
        end_3.setCidade("Foz do Iguaçu");
        end_3.setLogradouro("Almirante Barroso");
        end_3.setNumero("4545");
        end_3.setCep("85851010");
        end_3.setPrincipal(true);
        endereco_repository.save(end_3);

        Endereco end_4 = new Endereco();
        end_4.setDescricao("Casa");
        end_4.setBairro("Centro");
        end_4.setEstado("PR");
        end_4.setCidade("Foz do Iguaçu");
        end_4.setLogradouro("Almirante Barroso");
        end_4.setNumero("1424");
        end_4.setCep("85851010");
        end_4.setPrincipal(true);
        endereco_repository.save(end_4);

        Endereco end_5 = new Endereco();
        end_5.setDescricao("Trabalho");
        end_5.setBairro("Centro");
        end_5.setEstado("PR");
        end_5.setCidade("Foz do Iguaçu");
        end_5.setLogradouro("Almirante Barroso");
        end_5.setNumero("55553");
        end_5.setCep("85851010");
        end_5.setPrincipal(false);
        endereco_repository.save(end_2);

        //Adiciona as pessoas
        Cliente cliente_1 = new Cliente();
        cliente_1.setNome("Matheus Luan");
        cliente_1.setCelular("45 9999999");
        cliente_1.setLogin("matheus123");
        cliente_1.setSenha("123");

        Cliente cliente_2 = new Cliente();
        cliente_2.setCelular("45 9999999");
        cliente_2.setLogin("ademir123");
        cliente_2.setNome("Ademir Silva");
        cliente_2.setSenha("123");

        Cliente cliente_3 = new Cliente();
        cliente_3.setCelular("45 9999999");
        cliente_3.setLogin("ramos123");
        cliente_3.setNome("João Ramos");
        cliente_3.setSenha("ramos123");

        Cliente cliente_4 = new Cliente();
        cliente_4.setCelular("45 9999999");
        cliente_4.setLogin("Flavia123");
        cliente_4.setNome("Flavia Santos");
        cliente_4.setSenha("flavia123");

        List<Endereco> enderecos = new ArrayList<>();
        List<Endereco> enderecos2 = new ArrayList<>();
        List<Endereco> enderecos3 = new ArrayList<>();
        List<Endereco> enderecos4 = new ArrayList<>();

        enderecos.add(end_1);
        enderecos.add(end_5);
        cliente_1.setEnderecos(enderecos);

        enderecos2.add(end_2);
        cliente_2.setEnderecos(enderecos2);


        enderecos3.add(end_3);
        cliente_3.setEnderecos(enderecos3);


        enderecos4.add(end_4);
        cliente_4.setEnderecos(enderecos4);


        Farmaceutico farmaceutico_1 = new Farmaceutico();
        farmaceutico_1.setNome("Vinicius");
        farmaceutico_1.setCrf("1515-15");
        farmaceutico_1.setTelefone("45 9999999");
        farmaceutico_1.setLogin("vini123");
        farmaceutico_1.setSenha("123");

        farmaceutico_repository.save(farmaceutico_1);
        pessoa_repository.save(cliente_1);
        pessoa_repository.save(cliente_2);
        pessoa_repository.save(cliente_3);
        pessoa_repository.save(cliente_4);

        //Adiciona as medicamento
        Produto produto_1 = new Produto();
        produto_1.setNome("Neosoro");
        produto_1.setValor_unitario(5.00F);
        produto_1.setConteudo("30 ml");
        produto_1.setUso("Uso Adulto");
        produto_1.setFabricante("NeoQuimica");
        produto_1.setFormula("cloridrato de nafazolina 0,5mg/mL");
        produto_1.setCategoria(categoria_6);
        //produto_1.setImagem("1_9rEGDbSSZ23MNFV5JSEOVQCVF.png");
        produto_1.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_1.setPrecisa_receita(false);
        produto_1.setDescricao("Medicamento para descongestionamento nasal.");

        Produto produto_2 = new Produto();
        produto_2.setNome("Aspirina");
        produto_2.setValor_unitario(2.00F);
        produto_2.setCategoria(categoria_5);
        produto_2.setPrecisa_receita(false);
        produto_2.setImagem("https://www.google.com/imgres?imgurl=https%3A%2F%2Fstatic.vecteezy.com%2Fti%2Fvetor-gratis%2Fp1%2F1931805-icone-simbolo-na-garrafa-linha-e-preenchimento-estilo-simbolo-cruz-medica-gratis-vetor.jpg&imgrefurl=https%3A%2F%2Fpt.vecteezy.com%2Farte-vetorial%2F1931805-icone-simbolo-na-garrafa-linha-e-preenchimento-estilo-simbolo-cruz-medica&tbnid=OdEQey3QY49m9M&vet=12ahUKEwifm_GF3eX7AhVEBbkGHdiiCygQMygBegUIARDHAQ..i&docid=VnQvnW5g_sfoTM&w=980&h=980&q=medicamento&hl=pt-BR&ved=2ahUKEwifm_GF3eX7AhVEBbkGHdiiCygQMygBegUIARDHAQ");
        produto_2.setDescricao("Medicamento para alívio de dor de cabeça.");

        Produto produto_3 = new Produto();
        produto_3.setNome("Hastes Flexiveis");
        produto_3.setValor_unitario(11.00F);
        produto_3.setFabricante("Cotonete");
        produto_3.setUso("Uso adulto e infantil");
        //produto_3.setImagem("3_UyV0NIKde0vftivBf5sVuB5dN.jpg");
        produto_3.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_3.setCategoria(categoria_1);
        produto_3.setPrecisa_receita(false);
        produto_3.setDescricao("Medicamento para limpar o ouvido.");

        Produto produto_4 = new Produto();
        produto_4.setNome("Dorflex");
        produto_4.setValor_unitario(15.00F);
        produto_4.setConteudo("36 comprimidos");
        produto_4.setUso("Uso adulto e infantil");
        //produto_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_4.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_4.setCategoria(categoria_5);
        produto_4.setPrecisa_receita(false);
        produto_4.setDescricao("Medicamento para dor no corpo em geral.");

        Produto produto_5 = new Produto();
        produto_5.setNome("Fralda XG");
        produto_5.setValor_unitario(65.00F);
        produto_5.setConteudo("60 unidades");
        //produt5_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_5.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_5.setCategoria(categoria_4);
        produto_5.setUso("Uso infantil");
        produto_5.setPrecisa_receita(false);
        produto_5.setDescricao("Fralda XG para bebês de 10-15kg.");

        Produto produto_6 = new Produto();
        produto_6.setNome("Fralda G");
        produto_6.setValor_unitario(60.00F);
        produto_6.setConteudo("38 unidades");
        //produt6_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_6.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_6.setCategoria(categoria_4);
        produto_6.setPrecisa_receita(false);
        produto_6.setUso("Uso infantil");
        produto_6.setDescricao("Fralda G para bebês de 6-9kg.");

        Produto produto_7 = new Produto();
        produto_7.setNome("Pomada de Assadura");
        produto_7.setValor_unitario(60.00F);
        produto_7.setConteudo("150 gramas");
        produto_7.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_7.setCategoria(categoria_4);
        produto_7.setPrecisa_receita(false);
        produto_7.setUso("Uso adulto e infantil");
        produto_7.setDescricao("Pomada para assaduras.");

        Produto produto_8 = new Produto();
        produto_8.setNome("Cefalexina");
        produto_8.setValor_unitario(77.00F);
        produto_8.setConteudo("100 ml");
        //produt8_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_8.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_8.setCategoria(categoria_2);
        produto_8.setUso("Uso adulto e infantil");
        produto_8.setPrecisa_receita(true);
        produto_8.setDescricao("Indicado para o tratamento de uma série de processos infecciosos causados por bactérias, como sinusites, infecções no trato respiratório, otite média, infecções da pele e tecidos moles, infecções ósseas, infecções do trato genital e urinário e infecções dentárias.");

        Produto produto_9 = new Produto();
        produto_9.setNome("Amoxicilina");
        produto_9.setValor_unitario(77.00F);
        produto_9.setConteudo("100 ml");
        //produt9_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_9.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_9.setCategoria(categoria_2);
        produto_9.setUso("Uso adulto e infantil");
        produto_9.setPrecisa_receita(true);
        produto_9.setDescricao("Antibiótico de amplo espectro indicado para o tratamento de infecções bacterianas causadas por germes sensíveis à ação da Amoxicilina.");

        Produto produto_10 = new Produto();
        produto_10.setNome("Penicilina");
        produto_10.setValor_unitario(41.00F);
        produto_10.setConteudo("130 ml");
        //produt10_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_10.setImagem("https://www.istockphoto.com/br/foto/levita%C3%A7%C3%A3o-de-p%C3%ADlulas-em-um-fundo-preto-gm545582736-98385563?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fpt%2Fimages%2Fsearch%2Fremedio%2F%3Fmanual_search%3D1&utm_term=remedio");
        produto_10.setCategoria(categoria_2);
        produto_10.setUso("Uso adulto e infantil");
        produto_10.setPrecisa_receita(true);
        produto_10.setDescricao("Antibióticos do grupo dos betalactâmicos profusamente utilizados no tratamento de infecções causadas por bactérias sensíveis.");



        medicamento_repository.save(produto_1);
        medicamento_repository.save(produto_2);
        medicamento_repository.save(produto_3);
        medicamento_repository.save(produto_4);
        medicamento_repository.save(produto_5);
        medicamento_repository.save(produto_6);
        medicamento_repository.save(produto_7);
        medicamento_repository.save(produto_8);
        medicamento_repository.save(produto_9);
        medicamento_repository.save(produto_10);

    }

}
