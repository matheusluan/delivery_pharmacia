package com.ifpr.delivery_pharmacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
    String logradouro;
    String bairro;
    String numero;
    String cidade;
    String estado;
    String cep;

    @Nullable
    String observacao;

}
