package com.example.cine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cine.model.Cliente;
import com.example.cine.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository clienteRepository;
	
	// Método para obtener todos los clientes
	public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
	
    // Método para obtener un cliente por su ID
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
    
    // Método para crear un nuevo cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    // Método para editar un cliente existente
    public Optional<Cliente> actualizarCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setCifNif(clienteActualizado.getCifNif());
            cliente.setDireccion(clienteActualizado.getDireccion());
            cliente.setTelefono(clienteActualizado.getTelefono());
            cliente.setCp(clienteActualizado.getCp());
            cliente.setProvincia(clienteActualizado.getProvincia());
            clienteRepository.save(cliente);
        }
        return clienteExistente;
    }

    // Método para eliminar un cliente por su ID
    public void eliminarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
