package com.ifpr.delivery_pharmacia.services;

import com.ifpr.delivery_pharmacia.enums.MedicamentoTipo;
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
    EntregadorRepository entregador_repository;
    MedicamentoRepository medicamento_repository;

    VendaRepository venda_repository;

    EnderecoRepository endereco_repository;

    @PostMapping("/adicionar")
    public void getAllPerson(){

        //Endereço
        Endereco end_1 = new Endereco();
        end_1.setDescricao("Casa");
        end_1.setBairro("Tres Lagoa");
        end_1.setEstado("PR");
        end_1.setEstado("85862702");
        end_1.setCidade("Foz do Iguaçu");
        end_1.setLogradouro("Cesar Garcia da Rocha");
        end_1.setNumero("515151");
        end_1.setCep("85802702");
        endereco_repository.save(end_1);

        //Adiciona as pessoas
        Cliente cliente_1 = new Cliente();
        cliente_1.setNome("Matheus Luan");
        cliente_1.setCelular("45 9999999");

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(end_1);
        cliente_1.setEnderecos(enderecos);

        Farmaceutico farmaceutico_1 = new Farmaceutico();
        farmaceutico_1.setNome("Vinicius");
        farmaceutico_1.setDocumento("1515");
        farmaceutico_1.setCelular("45 9999999");

        Entregador entregador_1 = new Entregador();
        entregador_1.setNome("Ademir");
        entregador_1.setCelular("45 9999999");

        pessoa_repository.save(cliente_1);
        farmaceutico_repository.save(farmaceutico_1);
        entregador_repository.save(entregador_1);

        //Adiciona as medicamento
        Medicamento medicamento_1 = new Medicamento();
        medicamento_1.setNome("Neosoro");
        medicamento_1.setValor(5.00F);
        medicamento_1.setConteudo("30 ml");
        medicamento_1.setUso("Uso Adulto");
        medicamento_1.setFabricante("NeoQuimica");
        medicamento_1.setFormula("cloridrato de nafazolina 0,5mg/mL");
        medicamento_1.setTipo(MedicamentoTipo.GENERICOS);
        medicamento_1.setImagem("1_9rEGDbSSZ23MNFV5JSEOVQCVF.png");
        medicamento_1.setPrecisa_receita(false);
        medicamento_1.setDescricao("Medicamento para descongestionamento nasal.");

        Medicamento medicamento_2 = new Medicamento();
        medicamento_2.setNome("Aspirina");
        medicamento_2.setValor(2.00F);
        medicamento_2.setTipo(MedicamentoTipo.GENERICOS);
        medicamento_2.setPrecisa_receita(false);
        medicamento_2.setDescricao("Medicamento para alívio de dor de cabeça.");

        Medicamento medicamento_3 = new Medicamento();
        medicamento_3.setNome("Haster Flexiveis");
        medicamento_3.setValor(11.00F);
        medicamento_3.setFabricante("Cotonete");
        medicamento_3.setUso("Uso adulto e infantil");
        medicamento_3.setImagem("3_UyV0NIKde0vftivBf5sVuB5dN.jpg");
        medicamento_3.setTipo(MedicamentoTipo.HIGIENE);
        medicamento_3.setPrecisa_receita(false);
        medicamento_3.setDescricao("Medicamento para limpar o ouvido.");

        Medicamento medicamento_4 = new Medicamento();
        medicamento_4.setNome("Dorflex");
        medicamento_4.setValor(15.00F);
        medicamento_4.setConteudo("36 comprimidos");
        medicamento_4.setImagem("4_whkkivzGALrFf5cAWHCNoiCib.png");
        medicamento_4.setTipo(MedicamentoTipo.GENERICOS);
        medicamento_4.setPrecisa_receita(false);
        medicamento_4.setDescricao("Medicamento para dor no corpo em geral.");


        medicamento_repository.save(medicamento_1);
        medicamento_repository.save(medicamento_2);
        medicamento_repository.save(medicamento_3);
        medicamento_repository.save(medicamento_4);

    }

}
