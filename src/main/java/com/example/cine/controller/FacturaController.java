package com.example.cine.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cine.model.Factura;
import com.example.cine.service.FacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
    private FacturaService facturaService;

    // Método para obtener todas las facturas
    @GetMapping
    public List<Factura> obtenerTodasLasFacturas() {
        return facturaService.getAllFacturas();
    }

    // Método para crear una nueva factura
    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaService.createFactura(factura);
    }

    // Método para obtener una factura por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        Optional<Factura> facturaExistente = facturaService.getFacturaPorId(id);
        if (facturaExistente.isPresent()) {
            return ResponseEntity.ok(facturaExistente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para actualizar una factura por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura facturaActualizada) {
        Optional<Factura> facturaExistente = facturaService.actualizarFactura(id, facturaActualizada);
        if (facturaExistente.isPresent()) {
            return ResponseEntity.ok(facturaExistente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Método para eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    public void eliminarClientePorId(@PathVariable Long id) {
    	facturaService.eliminarFacturaPorId(id);
    }
    
    @PutMapping("/{id}/pagado")
    public ResponseEntity<String> marcarPagado(@PathVariable Long id) {
      facturaService.marcarPagado(id, true);
      return ResponseEntity.ok("Estado de pagado actualizado a true");
    }

    @PutMapping("/{id}/nopagado")
    public ResponseEntity<String> marcarNoPagado(@PathVariable Long id) {
      facturaService.marcarPagado(id, false);
      return ResponseEntity.ok("Estado de pagado actualizado a false");
    }
}
