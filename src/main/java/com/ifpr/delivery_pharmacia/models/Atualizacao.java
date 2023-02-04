package com.ifpr.delivery_pharmacia.models;

import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atualizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    VendaStatus status;
    Date dh_atualizacao = new Date();

}
