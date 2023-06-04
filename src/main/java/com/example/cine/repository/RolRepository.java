package com.example.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cine.model.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}