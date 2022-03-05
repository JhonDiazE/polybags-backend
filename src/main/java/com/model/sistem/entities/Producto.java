package com.model.sistem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Producto {
	
	@Column(name="id_producto")
	@Id
	private String id;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_unidad")
	private Unidad unidad;
	
	@ManyToOne
	@JoinColumn(name = "id_linea")
	private Linea linea;
	
	private BigDecimal precio;
	private String tipoMonedaPrecio; //` char(1) DEFAULT 'D',
	private String estado;
	
}
