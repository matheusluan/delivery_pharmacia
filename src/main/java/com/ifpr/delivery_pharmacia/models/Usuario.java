package com.ifpr.delivery_pharmacia.models;

import com.ifpr.delivery_pharmacia.enums.UsuarioTipo;
import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String celular;

    //Campo quando o usuario for um cliente
    @Column(unique = true, nullable = true)
    String cpf;

    //Campo quando o usuario for um farmaceutico
    @Column(unique = true, nullable = true)
    String crf;

    @Enumerated(EnumType.STRING)
    UsuarioTipo usuarioTipo;

    @Column(unique = true)
    String username;
    String password;

    @Nullable
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Endereco> enderecos;


    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
