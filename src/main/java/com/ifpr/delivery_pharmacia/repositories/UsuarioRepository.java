package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.enums.UsuarioTipo;
import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.ifpr.delivery_pharmacia.models.Usuario;
import com.ifpr.delivery_pharmacia.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpf(String cpf);
    Usuario findByCrf(String crf);
    Usuario findByUsername(String username);

    List<Usuario> findByUsuarioTipo(UsuarioTipo usuarioTipo);

}
