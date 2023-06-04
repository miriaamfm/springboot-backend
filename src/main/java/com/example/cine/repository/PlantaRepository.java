package com.example.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cine.model.Planta;


@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long>{
	List<Planta> findByNombre(String nombre);
	

	 
}
