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

import com.example.cine.model.Cliente;
import com.example.cine.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
    private ClienteService clienteService;
	
	// Método para obtener todos los clientes
    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.getAllClientes();
    }

    // Método para obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para crear un nuevo cliente
    @PostMapping
    public Cliente crearNuevoCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    // Método para editar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteService.actualizarCliente(id, clienteActualizado);
        if (clienteExistente.isPresent()) {
            return ResponseEntity.ok(clienteExistente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    public void eliminarClientePorId(@PathVariable Long id) {
        clienteService.eliminarClientePorId(id);
    }
}
