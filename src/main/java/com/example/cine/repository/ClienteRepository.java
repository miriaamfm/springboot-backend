package com.example.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cine.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findByNombre(String nombre);
	

	 
}