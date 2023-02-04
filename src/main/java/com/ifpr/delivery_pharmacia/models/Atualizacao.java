package com.ifpr.delivery_pharmacia.models;

import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.Nullable;

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

    @NotNull
    VendaStatus status;
    @NotNull
    Date dh_atualizacao = new Date();

}
