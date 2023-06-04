package com.example.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cine.model.PlantaVendida;

@Repository
public interface PlantaVendidaRepository extends JpaRepository<PlantaVendida, Long>{
	

	 
}