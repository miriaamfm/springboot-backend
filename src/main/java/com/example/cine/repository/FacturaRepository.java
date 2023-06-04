package com.example.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cine.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{


}
