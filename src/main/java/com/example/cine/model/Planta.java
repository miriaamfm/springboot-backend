package com.example.cine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="plantas")
public class Planta {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="stock")
	private Long stock;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

//	public Planta(Long id, String nombre, Double precio) {
//		this.id = id;
//		this.nombre = nombre;
//		this.precio = precio;
//	}
	
	
	public Planta(Long id, String nombre, Double precio, Long stock) {
		
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Planta() {

	}
}
