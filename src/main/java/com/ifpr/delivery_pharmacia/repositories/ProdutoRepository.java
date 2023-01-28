package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.models.Categoria;
import com.ifpr.delivery_pharmacia.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(Categoria categoria);

    List<Produto> findByNomeContains(String nome);

}
