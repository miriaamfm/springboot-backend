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

import com.example.cine.model.PlantaVendida;
import com.example.cine.service.PlantaVendidaService;

@RestController
@RequestMapping("/plantasVendidas")
public class PlantaVendidaController {
	@Autowired
    private PlantaVendidaService plantaVendidaService;

    // Método para obtener todas las plantas
    @GetMapping
    public List<PlantaVendida> getAllPlantas() {
        return plantaVendidaService.getAllPlantas();
    }

    // Método para obtener una planta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantaVendida> getPeliculasPorId(@PathVariable Long id) {
        Optional<PlantaVendida> planta = plantaVendidaService.findById(id);
        if (planta.isPresent()) {
            return new ResponseEntity<>(planta.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para crear una nueva planta
    @PostMapping
    public PlantaVendida crearNuevaPlanta(@RequestBody PlantaVendida planta) {
        return plantaVendidaService.crearPlanta(planta);
    }

    // Método para editar una planta existente
    @PutMapping("/{id}")
    public ResponseEntity<PlantaVendida> actualizarPlanta(@PathVariable Long id, @RequestBody PlantaVendida plantaActualizada) {
        Optional<PlantaVendida> plantaExistente = plantaVendidaService.actualizarPlanta(id, plantaActualizada);
        if (plantaExistente.isPresent()) {
            return ResponseEntity.ok(plantaExistente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para eliminar una planta por su ID
    @DeleteMapping("/{id}")
    public void eliminarPlantaPorId(@PathVariable Long id) {
    	plantaVendidaService.eliminarPlantaPorId(id);
    }
}
