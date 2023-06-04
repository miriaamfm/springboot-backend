package com.example.cine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cine.model.Planta;
import com.example.cine.model.PlantaVendida;
import com.example.cine.service.PlantaService;

@RestController
@RequestMapping("/plantas")
public class PlantaController {
	@Autowired
    private PlantaService plantaService;

    // Método para obtener todas las plantas
    @GetMapping
    public List<Planta> getAllPlantas() {
        return plantaService.getAllPlantas();
    }

    // Método para obtener una planta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Planta> getPeliculasPorId(@PathVariable Long id) {
        Optional<Planta> planta = plantaService.findById(id);
        if (planta.isPresent()) {
            return new ResponseEntity<>(planta.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para crear una nueva planta
    @PostMapping
    public Planta crearNuevaPlanta(@RequestBody Planta planta) {
        return plantaService.crearPlanta(planta);
    }

    // Método para editar una planta existente
    @PutMapping("/{id}")
    public ResponseEntity<Planta> actualizarPlanta(@PathVariable Long id, @RequestBody Planta plantaActualizada) {
        Optional<Planta> plantaExistente = plantaService.actualizarPlanta(id, plantaActualizada);
        if (plantaExistente.isPresent()) {
            return ResponseEntity.ok(plantaExistente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 // Método para editar el stock de una planta existente
    @PostMapping("/actualizar-stock")
    public ResponseEntity<String> actualizarStockPlanta(@RequestBody PlantaVendida plantaVendida) {
      try {
        plantaService.actualizarStockPlanta(plantaVendida);
        return ResponseEntity.ok("Stock de planta actualizado correctamente");
      } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
    }

    // Método para eliminar una planta por su ID
    @DeleteMapping("/{id}")
    public void eliminarPlantaPorId(@PathVariable Long id) {
    	plantaService.eliminarPlantaPorId(id);
    }
}
