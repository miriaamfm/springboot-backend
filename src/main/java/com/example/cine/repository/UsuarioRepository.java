package com.example.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cine.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}