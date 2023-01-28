package com.ifpr.delivery_pharmacia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/cliente/add",
                             "/farmaceutico/add",
                             "/produto",
                             "/categoria",
                             "/cliente",
                             "/adicionar")
                .permitAll()
                /*
                .antMatchers("/cliente/edit/**",
                             "/venda/add",
                             "/venda/add_with_image",
                             "/venda/edit")
                .hasRole("CLIENTE")
                .antMatchers("/farmaceutico/edit/**",
                             "/venda/statusAndCliente",
                             "/venda/status",
                             "/venda/edit_status/**")
                .hasRole("FARMACEUTICO")
                */
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
