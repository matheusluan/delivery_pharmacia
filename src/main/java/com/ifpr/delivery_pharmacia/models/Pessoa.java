package com.ifpr.delivery_pharmacia.models;

import com.ifpr.delivery_pharmacia.enums.PessoaTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    String celular;

    @Enumerated(EnumType.STRING)
    PessoaTipo tipo;
}
