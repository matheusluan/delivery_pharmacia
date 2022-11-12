package com.ifpr.delivery_pharmacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String arquivo;

}
