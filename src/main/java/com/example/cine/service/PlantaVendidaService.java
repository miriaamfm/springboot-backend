package com.example.cine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cine.model.PlantaVendida;
import com.example.cine.repository.PlantaVendidaRepository;

@Service
public class PlantaVendidaService {
	@Autowired
    private PlantaVendidaRepository plantaVendidaRepository;
	
    // Método para obtener todas las plantas
    public List<PlantaVendida> getAllPlantas() {
        return plantaVendidaRepository.findAll();
    }
    
    // Método para obtener un cliente por su ID
    public Optional<PlantaVendida> findById(Long id) {
        return plantaVendidaRepository.findById(id);
    }
    
    // Método para crear una nueva planta
    public PlantaVendida crearPlanta(PlantaVendida plantaId) {
        return plantaVendidaRepository.save(plantaId);
    }
    
    // Método para editar una planta existente
    public Optional<PlantaVendida> actualizarPlanta(Long id, PlantaVendida plantaActualizada) {
        Optional<PlantaVendida> plantaExistente = plantaVendidaRepository.findById(id);
        if (plantaExistente.isPresent()) {
        	PlantaVendida planta = plantaExistente.get();
        	planta.setPlantaId(plantaActualizada.getPlantaId());
        	planta.setUnidades(plantaActualizada.getUnidades());
        	plantaVendidaRepository.save(planta);
        }
        return plantaExistente;
    }
    
    // Método para eliminar un cliente por su ID
    public void eliminarPlantaPorId(Long id) {
    	plantaVendidaRepository.deleteById(id);
    }
}
