package com.example.cine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cine.model.Planta;
import com.example.cine.model.PlantaVendida;
import com.example.cine.repository.PlantaRepository;


@Service
public class PlantaService {
	@Autowired
    private PlantaRepository plantaRepository;
	
    // Método para obtener todas las plantas
    public List<Planta> getAllPlantas() {
        return plantaRepository.findAll();
    }
    
    // Método para obtener un cliente por su ID
    public Optional<Planta> findById(Long id) {
        return plantaRepository.findById(id);
    }
    
    // Método para crear una nueva planta
    public Planta crearPlanta(Planta planta) {
        return plantaRepository.save(planta);
    }
    
    // Método para editar una planta existente
    public Optional<Planta> actualizarPlanta(Long id, Planta plantaActualizada) {
        Optional<Planta> plantaExistente = plantaRepository.findById(id);
        if (plantaExistente.isPresent()) {
        	Planta planta = plantaExistente.get();
        	planta.setNombre(plantaActualizada.getNombre());
        	planta.setPrecio(plantaActualizada.getPrecio());
        	planta.setStock(plantaActualizada.getStock());
        	plantaRepository.save(planta);
        }
        return plantaExistente;
    }
    
    public void actualizarStockPlanta(PlantaVendida plantaVendida) {
        Long plantaId = plantaVendida.getPlantaId().getId();
        Long unidadesVendidas = plantaVendida.getUnidades();
        
        Optional<Planta> plantaOptional = plantaRepository.findById(plantaId);
        
        if (plantaOptional.isPresent()) {
          Planta planta = plantaOptional.get();
          Long stockActualizado = planta.getStock() - unidadesVendidas;
          planta.setStock(stockActualizado);
          plantaRepository.save(planta);
        } else {
          throw new IllegalArgumentException("La planta con ID " + plantaId + " no existe.");
        }
      }
    
    
    // Método para eliminar un cliente por su ID
    public void eliminarPlantaPorId(Long id) {
        plantaRepository.deleteById(id);
    }
}
