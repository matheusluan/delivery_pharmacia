package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.enums.PessoaTipo;
import com.ifpr.delivery_pharmacia.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByTipo(PessoaTipo tipo);

}
