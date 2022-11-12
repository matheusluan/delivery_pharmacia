package com.ifpr.delivery_pharmacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String descricao;

}
