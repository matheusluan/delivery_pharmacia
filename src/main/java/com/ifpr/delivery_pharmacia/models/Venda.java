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
    String nome_entregador;
    String telefone_entregador;

    @Temporal(TemporalType.TIMESTAMP)
    Date dh_registro = new Date();

    @Nullable
    String observacoes;

    @OneToMany(cascade=CascadeType.PERSIST)
    List<Item> itens;

    @OneToMany(cascade=CascadeType.PERSIST)
    List<Receita> receitas;

    @OneToMany(cascade=CascadeType.PERSIST)
    List<Atualizacao> atualizacoes;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    Usuario cliente;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    Endereco endereco;

    @OneToOne
    @JoinColumn(name = "farmaceutico_id")
    Usuario farmaceutico;

    @Enumerated(EnumType.STRING)
    VendaStatus status;
}
