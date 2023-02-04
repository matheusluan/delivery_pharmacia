package com.ifpr.delivery_pharmacia.services;

import com.ifpr.delivery_pharmacia.enums.RoleName;
import com.ifpr.delivery_pharmacia.models.*;
import com.ifpr.delivery_pharmacia.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class Service {

    UsuarioRepository pessoa_repository;
    ProdutoRepository medicamento_repository;

    VendaRepository venda_repository;

    EnderecoRepository endereco_repository;

    CategoriaRepository categoria_repository;

    RoleRepository role_repository;

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


        //Adiciona as roles
        Role role_cliente = new Role();
        role_cliente.setRoleName(RoleName.ROLE_CLIENTE);
        role_repository.save(role_cliente);

        Role role_farmaceutico = new Role();
        role_farmaceutico.setRoleName(RoleName.ROLE_FARMACEUTICO);

        role_repository.save(role_farmaceutico);

        //Adiciona os medicamento
        Produto produto_1 = new Produto();
        produto_1.setNome("Neosoro");
        produto_1.setValor_unitario(5.00F);
        produto_1.setConteudo("30 ml");
        produto_1.setUso("Uso Adulto");
        produto_1.setFabricante("NeoQuimica");
        produto_1.setFormula("cloridrato de nafazolina 0,5mg/mL");
        produto_1.setCategoria(categoria_6);
        produto_1.setBula("O Neosoro® de uso adulto apresenta como principio ativo cloridrato de nafazolina o qual é um descongestionante nasal de uso local (mucosa do nariz), com um rápido início de ação vasoconstritora (aproximadamente 10 minutos) e com efeito prolongado (entre 2 a 6 horas).\n" +
                "\n" +
                "É indicado no tratamento da congestão nasal (obstrução nasal) para o alívio dos sintomas em resfriados, quadros alérgicos nasais, rinites e rinossinusites.");
        //produto_1.setImagem("1_9rEGDbSSZ23MNFV5JSEOVQCVF.png");
        produto_1.setImagem("https://images.tcdn.com.br/img/img_prod/740081/neosoro_0_5mg_ml_com_gotejador_com_30ml_neo_quimica_1405_1_a19248bba6def076b1fe4701263e6128.jpg");
        produto_1.setPrecisa_receita(false);
        produto_1.setDescricao("Medicamento para descongestionamento nasal.");

        Produto produto_2 = new Produto();
        produto_2.setNome("Aspirina");
        produto_2.setValor_unitario(2.00F);
        produto_2.setCategoria(categoria_5);
        produto_2.setPrecisa_receita(false);
        produto_2.setImagem("https://paguemenos.vtexassets.com/arquivos/ids/274392/Analgesico-Aspirina-500mg-a%E2%82%AC%E2%80%9C-caixa-com-20-comprimidos-Pague-Menos-43534-2.jpg?v=637305908740470000");
        produto_2.setDescricao("Medicamento para alívio de dor de cabeça.");

        Produto produto_3 = new Produto();
        produto_3.setNome("Hastes Flexiveis");
        produto_3.setValor_unitario(11.00F);
        produto_3.setFabricante("Cotonete");
        produto_3.setUso("Uso adulto e infantil");
        //produto_3.setImagem("3_UyV0NIKde0vftivBf5sVuB5dN.jpg");
        produto_3.setImagem("https://castronaves.vteximg.com.br/arquivos/ids/357966-1000-1000/13546_01.jpg?v=637227476807670000");
        produto_3.setCategoria(categoria_1);
        produto_3.setPrecisa_receita(false);
        produto_3.setDescricao("Medicamento para limpar o ouvido.");

        Produto produto_4 = new Produto();
        produto_4.setNome("Dorflex");
        produto_4.setValor_unitario(15.00F);
        produto_4.setConteudo("36 comprimidos");
        produto_4.setUso("Uso adulto e infantil");
        //produto_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        produto_4.setImagem("https://www.drogarianet.com.br/media/product/84e/analgesico-dorflex-36-comprimidos-8ca.jpg");
        produto_4.setCategoria(categoria_5);
        produto_4.setPrecisa_receita(false);
        produto_4.setDescricao("Medicamento para dor no corpo em geral.");

        Produto produto_5 = new Produto();
        produto_5.setNome("Fralda XG");
        produto_5.setValor_unitario(65.00F);
        produto_5.setConteudo("60 unidades");
        produto_5.setImagem("https://farmaciaindiana.vteximg.com.br/arquivos/ids/244801/7500435132459.jpg?v=637660370497570000");
        produto_5.setCategoria(categoria_4);
        produto_5.setUso("Uso infantil");
        produto_5.setPrecisa_receita(false);
        produto_5.setDescricao("Fralda XG para bebês de 10-15kg.");

        Produto produto_6 = new Produto();
        produto_6.setNome("Fralda G");
        produto_6.setValor_unitario(60.00F);
        produto_6.setConteudo("38 unidades");
        produto_6.setImagem("https://hiperideal.vteximg.com.br/arquivos/ids/188571-1000-1000/2090910.jpg?v=637497685205430000");
        produto_6.setCategoria(categoria_4);
        produto_6.setPrecisa_receita(false);
        produto_6.setUso("Uso infantil");
        produto_6.setDescricao("Fralda G para bebês de 6-9kg.");

        Produto produto_7 = new Produto();
        produto_7.setNome("Pomada de Assadura");
        produto_7.setValor_unitario(60.00F);
        produto_7.setConteudo("150 gramas");
        produto_7.setCategoria(categoria_4);
        produto_7.setImagem("https://cf.shopee.com.br/file/04725cf1ba91bdf6f691b622ca82c12a");
        produto_7.setPrecisa_receita(false);
        produto_7.setUso("Uso adulto e infantil");
        produto_7.setDescricao("Pomada para assaduras.");

        Produto produto_8 = new Produto();
        produto_8.setNome("Cefalexina");
        produto_8.setValor_unitario(77.00F);
        produto_8.setConteudo("100 ml");
        produto_8.setImagem("https://d3ugyf2ht6aenh.cloudfront.net/stores/001/271/831/products/82441-754cd83a432ae80d6216155961454729-640-0.jpg");
        produto_8.setCategoria(categoria_2);
        produto_8.setUso("Uso adulto e infantil");
        produto_8.setPrecisa_receita(true);
        produto_8.setDescricao("Indicado para o tratamento de uma série de processos infecciosos causados por bactérias, como sinusites, infecções no trato respiratório, otite média, infecções da pele e tecidos moles, infecções ósseas, infecções do trato genital e urinário e infecções dentárias.");

        Produto produto_9 = new Produto();
        produto_9.setNome("Amoxicilina");
        produto_9.setValor_unitario(77.00F);
        produto_9.setConteudo("100 ml");
        produto_9.setImagem("https://images.tcdn.com.br/img/img_prod/479811/agemoxi_cl_250_mg_antibacteriano_caes_e_gatos_a_base_de_amoxicilina_triidratada_e_clavulanato_de_pot_1221_1_7e3dbcc95acb1832fd2cf607a2c0451b.jpeg");
        produto_9.setCategoria(categoria_2);
        produto_9.setUso("Uso adulto e infantil");
        produto_9.setPrecisa_receita(true);
        produto_9.setDescricao("Antibiótico de amplo espectro indicado para o tratamento de infecções bacterianas causadas por germes sensíveis à ação da Amoxicilina.");

        Produto produto_10 = new Produto();
        produto_10.setNome("Penicilina");
        produto_10.setValor_unitario(41.00F);
        produto_10.setConteudo("130 ml");
        produto_10.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJgH1jmXIfoMXucu7_nTy-5BPljM4t8s0axA&usqp=CAU");
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
