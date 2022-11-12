package com.ifpr.delivery_pharmacia.repositories;


import com.ifpr.delivery_pharmacia.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaReceitaRepository extends JpaRepository<Receita, Long> {

}
