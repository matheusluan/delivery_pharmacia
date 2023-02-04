package com.ifpr.delivery_pharmacia.controllers;

import com.ifpr.delivery_pharmacia.enums.RoleName;
import com.ifpr.delivery_pharmacia.enums.UsuarioTipo;
import com.ifpr.delivery_pharmacia.models.Role;
import com.ifpr.delivery_pharmacia.models.Usuario;
import com.ifpr.delivery_pharmacia.models.Endereco;
import com.ifpr.delivery_pharmacia.repositories.EnderecoRepository;
import com.ifpr.delivery_pharmacia.repositories.RoleRepository;
import com.ifpr.delivery_pharmacia.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class UsuarioController {

    UsuarioRepository repository;
    EnderecoRepository endereco_repo;
    RoleRepository role_repo;



    //Busca os clientes
    @GetMapping("/cliente")
    public List<Usuario> getAllCliente(){
        return  repository.findByUsuarioTipo(UsuarioTipo.CLIENTE);
    }

    //Busca os farmaceuticos
    @GetMapping("/farmaceutico")
    public List<Usuario> getAllFarmaceutico(){
        return  repository.findByUsuarioTipo(UsuarioTipo.FARMACEUTICO);
    }

    @GetMapping("/cliente/{id}")
    public Usuario getCliente(@PathVariable Long id){

        Usuario usuario = repository.findById(id).get();

        if(usuario.getUsuarioTipo() == UsuarioTipo.CLIENTE)
            return usuario ;
        else
            throw new RuntimeException("ID não encontrado ou não é um cliente");
    }

    @GetMapping("/login/{username}")
    public Usuario login(@PathVariable String username){

        Usuario usuario = repository.findByUsername(username);

        if(usuario != null)
            return usuario ;
        else
            throw new RuntimeException("Usuário não encontrado");
    }


    @GetMapping("/farmaceutico/{id}")
    public Usuario getFarmaceutico(@PathVariable Long id){

        Usuario usuario = repository.findById(id).get();

        if(usuario.getUsuarioTipo() == UsuarioTipo.FARMACEUTICO)
            return usuario ;
        else
            throw new RuntimeException("ID não encontrado ou não é um farmaceutico");
    }

    //Adiciona cliente
    @PostMapping("/cliente/add")
    public Usuario addCliente(@RequestBody Usuario usuario){

        //Verifica se falta algum campo
        if(usuario.getUsername() == null
           || usuario.getCpf() == null
           || usuario.getPassword() == null
           || usuario.getNome() == null){
            throw new RuntimeException("Faltam campos");
        }

        //Verifica se já não existe cliente
        Usuario usuario_with_cpf = repository.findByCpf(usuario.getCpf());
        Usuario usuario_with_login = repository.findByUsername(usuario.getUsername());

        if(usuario_with_cpf != null){
            throw new RuntimeException("Cliente com cpf já existe");
        }

        if(usuario_with_login != null){
            throw new RuntimeException("Cliente com login já existe");
        }

        //Encripta a senha
        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));

        //Seta o tipo de usuario
        usuario.setUsuarioTipo(UsuarioTipo.CLIENTE);

        //Seta a role_cliente ao cliente
        Role role_cliente = role_repo.findByRoleName(RoleName.ROLE_CLIENTE);
        List<Role> roles_cliente = new ArrayList<>();
        roles_cliente.add(role_cliente);
        usuario.setRoles(roles_cliente);

        return  repository.save(usuario);
    }

    @PostMapping("/farmaceutico/add")
    public Usuario addFarmaceutico(@RequestBody Usuario usuario){

        //Verifica se falta algum campo
        if(usuario.getUsername() == null
                || usuario.getCrf() == null
                || usuario.getPassword() == null
                || usuario.getNome() == null){
            throw new RuntimeException("Faltam campos");
        }

        //Verifica se já não existe cliente
        Usuario usuario_with_crf = repository.findByCrf(usuario.getCrf());
        Usuario usuario_with_login = repository.findByUsername(usuario.getUsername());

        if(usuario_with_crf != null){
            throw new RuntimeException("Farmaceutico com cpf já existe");
        }

        if(usuario_with_login != null){
            throw new RuntimeException("Farmaceutico com login já existe");
        }

        //Encripta a senha
        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));

        //Seta o tipo de usuario
        usuario.setUsuarioTipo(UsuarioTipo.FARMACEUTICO);

        //Seta a role_farmaceutico ao farmaceutico
        Role role_farmaceutico = role_repo.findByRoleName(RoleName.ROLE_FARMACEUTICO);
        List<Role> roles_farmaceutico = new ArrayList<>();
        roles_farmaceutico.add(role_farmaceutico);
        usuario.setRoles(roles_farmaceutico);

        return  repository.save(usuario);
    }


    //Edita o cliente

    @PutMapping("/cliente/edit/{id}")
    public Usuario editCliente(@RequestBody Usuario usuario, @PathVariable Long id  ){

        try {
            Usuario old_usuario = repository.findById(id).get();

            if (old_usuario != null) {

                //Só vai alterar oq foi mandado no body
                if (usuario.getCelular() != null) {
                    old_usuario.setCelular(usuario.getCelular());
                }

                if (usuario.getNome() != null) {
                    old_usuario.setNome(usuario.getNome());
                }

                if (usuario.getPassword() != null) {
                    old_usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
                }

                if (usuario.getCpf() != null) {
                    old_usuario.setCpf(usuario.getCpf());
                }

                if (usuario.getUsername() != null) {
                    old_usuario.setUsername(usuario.getUsername());
                }

                return  repository.save(old_usuario);
            }
        }catch (Exception e){
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }

        throw new RuntimeException("Não fez nada");
    }

    //Edita o farmaceutico

    @PutMapping("/farmaceutico/edit/{id}")
    public Usuario editFarmaceutico(@RequestBody Usuario usuario, @PathVariable Long id  ){

        try {
            Usuario old_usuario = repository.findById(id).get();

            if (old_usuario != null) {

                //Só vai alterar oq foi mandado no body
                if (usuario.getCelular() != null) {
                    old_usuario.setCelular(usuario.getCelular());
                }

                if (usuario.getNome() != null) {
                    old_usuario.setNome(usuario.getNome());
                }

                if (usuario.getPassword() != null) {
                    old_usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
                }

                if (usuario.getCrf() != null) {
                    old_usuario.setCpf(usuario.getCpf());
                }

                if (usuario.getUsername() != null) {
                    old_usuario.setUsername(usuario.getUsername());
                }

                return  repository.save(old_usuario);
            }
        }catch (Exception e){
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }

        throw new RuntimeException("Não fez nada");
    }

    //Cadastra novo endereço no cliente

    @PostMapping("/cliente/endereco/{id}")
    public Usuario addEndereco(@RequestBody Endereco endereco, @PathVariable Long id ){

        Usuario usuario = repository.findById(id).get();

        if (usuario.getUsuarioTipo() == UsuarioTipo.CLIENTE){
            endereco_repo.save(endereco);

            List<Endereco> listAdress = usuario.getEnderecos();
            listAdress.add(endereco);
            usuario.setEnderecos(listAdress);

            return  repository.save(usuario);
        }else{
            throw new RuntimeException("Endereço não encontrado com o id: " + id);
        }

    }

    //Altera um endereço com base no id do endereço
    @PutMapping ("/endereco/{id}/{id_cliente}")
    public Endereco EditEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {

        try {
            Endereco old_endereco = endereco_repo.findById(id).get();

            if (old_endereco != null) {

                //Só vai alterar oq foi mandado no body
                if (endereco.getDescricao() != null) {
                    old_endereco.setDescricao(endereco.getDescricao());
                }

                if (endereco.getLogradouro() != null) {
                    old_endereco.setLogradouro(endereco.getLogradouro());
                }

                if (endereco.getBairro() != null) {
                    old_endereco.setBairro(endereco.getBairro());
                }

                if (endereco.getNumero() != null) {
                    old_endereco.setNumero(endereco.getNumero());
                }

                if (endereco.getCidade() != null) {
                    old_endereco.setCidade(endereco.getCidade());
                }

                if (endereco.getEstado() != null) {
                    old_endereco.setEstado(endereco.getEstado());
                }

                if (endereco.getCep() != null) {
                    old_endereco.setCep(endereco.getCep());
                }

                if (endereco.getObservacao() != null) {
                    old_endereco.setObservacao(endereco.getObservacao());
                }

                return endereco_repo.save(old_endereco);
            }
        }catch(Exception ex ){
                throw new RuntimeException("Endereço não encontrado com o id: " + id);
        }
        throw new RuntimeException("Não fez nada");
    }

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
