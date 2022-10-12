package com.ifpr.delivery_pharmacia.models;


import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Float valor_produtos;
    Float valor_frete;
    Float valor_total;
    Date dh_registro;

    @Nullable
    String observacoes;

    @OneToMany(cascade=CascadeType.PERSIST)
    List<VendaItem> itens;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

    @OneToOne
    @JoinColumn(name = "farmaceutico_id")
    Farmaceutico farmaceutico;

    @OneToOne
    Entregador entregador;

    @Enumerated(EnumType.STRING)
    VendaStatus status;
}
