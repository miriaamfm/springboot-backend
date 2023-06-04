package com.example.cine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="cifNif")
	private String cifNif;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="cp")
	private Long cp;
	
	@Column(name="provincia")
	private String provincia;

	
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

	public String getCifNif() {
		return cifNif;
	}

	public void setCifNif(String cifNif) {
		this.cifNif = cifNif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getCp() {
		return cp;
	}

	public void setCp(Long cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Cliente(Long id, String nombre, String cifNif, String direccion, String telefono, Long cp,
			String provincia) {
		this.id = id;
		this.nombre = nombre;
		this.cifNif = cifNif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cp = cp;
		this.provincia = provincia;
	}

	public Cliente() {
		
	}
}
