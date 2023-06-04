package com.example.cine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="planta_vendida")
public class PlantaVendida {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
    @JoinColumn(name = "plantaId")
    private Planta plantaId;
	
	@Column(name="unidades")
    private Long unidades;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planta getPlantaId() {
		return plantaId;
	}

	public void setPlantaId(Planta plantaId) {
		this.plantaId = plantaId;
	}

	public Long getUnidades() {
		return unidades;
	}

	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}

	public PlantaVendida(Long id, Planta plantaId, Long unidades) {
		this.id = id;
		this.plantaId = plantaId;
		this.unidades = unidades;
	}
	
	public PlantaVendida() {
		
	}

}
