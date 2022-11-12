package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.ifpr.delivery_pharmacia.models.Cliente;
import com.ifpr.delivery_pharmacia.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByStatusAndCliente(VendaStatus status, Cliente cliente);
    List<Venda> findByStatus(VendaStatus status);
}
