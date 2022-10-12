package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
