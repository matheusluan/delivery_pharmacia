package com.ifpr.delivery_pharmacia.models;

import com.ifpr.delivery_pharmacia.enums.MedicamentoTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Float valor;
    Boolean precisa_receita;

    @Nullable
    String descricao;

    @Nullable
    String bula;

    @Nullable
    String imagem;

    @Nullable
    Boolean precisa_recolher_receita;

    @Nullable
    @Enumerated(EnumType.STRING)
    MedicamentoTipo tipo;
}
