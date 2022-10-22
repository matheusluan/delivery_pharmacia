package com.ifpr.delivery_pharmacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer item;
    Integer quantidade;
    Float valor_unitario;
    Float valor_total;

    @OneToOne
    @JoinColumn(name = "medicamento_id")
    Medicamento medicamento;

}
