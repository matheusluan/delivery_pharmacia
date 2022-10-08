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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String descricao;
    Float valor;
    Boolean precisa_bula;

    @Nullable
    String imagem;

    @Nullable
    Boolean precisa_recolher_bula;

    @Enumerated(EnumType.STRING)
    MedicamentoTipo tipo;
}
