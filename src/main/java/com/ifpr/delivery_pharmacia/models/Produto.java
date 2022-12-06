package com.ifpr.delivery_pharmacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Float valor_unitario;
    Boolean precisa_receita;

    @Temporal(TemporalType.TIMESTAMP)
    Date dh_registro;

    @Nullable
    String fabricante;
    String formula;
    String conteudo;
    String uso;

    @Column(name="descricao", length=5000)
    String descricao;

    @Column(name="bula", length=5000)
    String bula;

    @Column(name="imagem", length=5000)
    String imagem;

    Boolean precisa_recolher_receita;


    @OneToOne
    @JoinColumn(name = "categoria_id")
    Categoria categoria;
}
