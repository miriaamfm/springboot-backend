package com.example.cine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cine.model.Factura;
import com.example.cine.model.PlantaVendida;
import com.example.cine.repository.ClienteRepository;
import com.example.cine.repository.FacturaRepository;
import com.example.cine.repository.PlantaRepository;
import com.example.cine.repository.PlantaVendidaRepository;

@Service
public class FacturaService {
	@Autowired
	 private FacturaRepository facturaRepository;
	
	@Autowired
	 private PlantaRepository plantaRepository;
	
	@Autowired
	 private PlantaVendidaRepository plantaVendidaRepository;
	
	@Autowired
	 private ClienteRepository clienteRepository;
	 
   public List<Factura> getAllFacturas() {
       return facturaRepository.findAll();
   }
   
   public Optional<Factura> getFacturaPorId(Long id) {
       return facturaRepository.findById(id);
   }
   

   @PostMapping
   public Factura createFactura(@RequestBody Factura factura) {
       for (PlantaVendida plantaVendida : factura.getPlantas()) {
           plantaVendidaRepository.save(plantaVendida);
       }

       return facturaRepository.save(factura);
   }

   
   public Optional<Factura> actualizarFactura(Long id, Factura facturaActualizada) {
	    Optional<Factura> facturaExistente = facturaRepository.findById(id);
	    if (facturaExistente.isPresent()) {
	        Factura factura = facturaExistente.get();
	        factura.setIdCliente(facturaActualizada.getIdCliente());
	        factura.setFacturaNum(facturaActualizada.getFacturaNum());
	        factura.setFechaFactura(facturaActualizada.getFechaFactura());
	        factura.setTotalPagado(facturaActualizada.getTotalPagado());
	        factura.setPagado(facturaActualizada.getPagado());
	        factura.setIvaReq(facturaActualizada.getIvaReq());
	        factura.setPorIvaReq(facturaActualizada.getPorIvaReq());

	        factura.getPlantas().clear();

	        for (PlantaVendida plantaVendida : facturaActualizada.getPlantas()) {
	            PlantaVendida nuevaPlantaVendida = new PlantaVendida();
	            nuevaPlantaVendida.setPlantaId(plantaVendida.getPlantaId());
	            nuevaPlantaVendida.setUnidades(plantaVendida.getUnidades());
	            factura.getPlantas().add(nuevaPlantaVendida);
	            plantaVendidaRepository.save(nuevaPlantaVendida);
	        }

	        facturaRepository.save(factura);
	    }
	    return facturaExistente;
	}

   
   public void eliminarFacturaPorId(Long id) {
       facturaRepository.deleteById(id);
   }
   
   
   public void marcarPagado(Long id, boolean pagado) {
	    Optional<Factura> facturaOptional = facturaRepository.findById(id);
	    if (facturaOptional.isPresent()) {
	      Factura factura = facturaOptional.get();
	      factura.setPagado(pagado);
	      facturaRepository.save(factura);
	    } else {
	      throw new RuntimeException("No se encontró la factura con el ID especificado");
	    }
	  }
}
