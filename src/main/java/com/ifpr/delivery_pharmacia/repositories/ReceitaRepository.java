package com.ifpr.delivery_pharmacia.repositories;


import com.ifpr.delivery_pharmacia.enums.RoleName;
import com.ifpr.delivery_pharmacia.models.Receita;
import com.ifpr.delivery_pharmacia.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Receita findByArquivo(String arquivo);
}
