package com.example.cine.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
    @JoinColumn(name = "idCliente")
	private Cliente idCliente;
	
    @ManyToMany
    @JoinTable(
        name = "factura_plantas",
        joinColumns = @JoinColumn(name = "idFactura"),
        inverseJoinColumns = @JoinColumn(name = "idPlanta"))
    private Set<PlantaVendida> plantas = new HashSet<>();

    @Column(name="facturaNum")
	private Long facturaNum;
    
	@Column(name="fechaFactura")
	private Date fechaFactura;
	
	@Column(name="totalPagado")
	private Double totalPagado;
	
	@Column(name="pagado")
	private Boolean pagado;
	
	@Column(name="ivaReq")
	private String ivaReq;

	@Column(name="porIvaReq")
	private Double porIvaReq;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Set<PlantaVendida> getPlantas() {
		return plantas;
	}

	public void setPlantas(Set<PlantaVendida> plantas) {
		this.plantas = plantas;
	}

	public Long getFacturaNum() {
		return facturaNum;
	}

	public void setFacturaNum(Long facturaNum) {
		this.facturaNum = facturaNum;
	}
	
	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Double getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(Double totalPagado) {
		this.totalPagado = totalPagado;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public String getIvaReq() {
		return ivaReq;
	}

	public void setIvaReq(String ivaReq) {
		this.ivaReq = ivaReq;
	}

	
	
	public Double getPorIvaReq() {
		return porIvaReq;
	}

	public void setPorIvaReq(Double porIvaReq) {
		this.porIvaReq = porIvaReq;
	}

	public Factura(Long id, Cliente idCliente, Set<PlantaVendida> plantas, Long facturaNum, Date fechaFactura, Double totalPagado,
			Boolean pagado, String ivaReq, Double porIvaReq) {
		this.id = id;
		this.idCliente = idCliente;
		this.plantas = plantas;
		this.facturaNum=facturaNum;
		this.fechaFactura = fechaFactura;
		this.totalPagado = totalPagado;
		this.pagado = pagado;
		this.ivaReq = ivaReq;
		this.porIvaReq = porIvaReq;
	}





	public Factura() {
		
	}
}
