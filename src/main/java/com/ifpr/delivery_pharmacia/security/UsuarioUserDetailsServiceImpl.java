package com.ifpr.delivery_pharmacia.security;

import com.ifpr.delivery_pharmacia.models.Usuario;
import com.ifpr.delivery_pharmacia.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioUserDetailsServiceImpl implements UserDetailsService {

    final
    UsuarioRepository usuarioRepository;

    public UsuarioUserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        return new User(usuario.getUsername(), usuario.getPassword(),true, true, true,true, usuario.getAuthorities());
    }
}
