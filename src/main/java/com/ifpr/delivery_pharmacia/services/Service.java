package com.ifpr.delivery_pharmacia.services;

import com.ifpr.delivery_pharmacia.enums.MedicamentoTipo;
import com.ifpr.delivery_pharmacia.models.Cliente;
import com.ifpr.delivery_pharmacia.models.Entregador;
import com.ifpr.delivery_pharmacia.models.Farmaceutico;
import com.ifpr.delivery_pharmacia.models.Medicamento;
import com.ifpr.delivery_pharmacia.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Service {

    ClienteRepository pessoa_repository;
    FarmaceuticoRepository farmaceutico_repository;
    EntregadorRepository entregador_repository;
    MedicamentoRepository medicamento_repository;
    VendaRepository venda_repository;

    @PostMapping("/adicionar")
    public void getAllPerson(){

        //Adiciona as pessoas
        Cliente cliente_1 = new Cliente();
        cliente_1.setNome("Matheus Luan");
        cliente_1.setCelular("45 9999999");

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
        medicamento_1.setTipo(MedicamentoTipo.GENERICOS);
        medicamento_1.setPrecisa_receita(false);
        medicamento_1.setDescricao("Medicamento para descongestionamento nasal.");

        Medicamento medicamento_2 = new Medicamento();
        medicamento_2.setNome("Aspirina");
        medicamento_2.setValor(2.00F);
        medicamento_2.setTipo(MedicamentoTipo.GENERICOS);
        medicamento_2.setPrecisa_receita(false);
        medicamento_2.setDescricao("Medicamento para alívio de dor de cabeça.");

        medicamento_repository.save(medicamento_1);
        medicamento_repository.save(medicamento_2);

    }

}
