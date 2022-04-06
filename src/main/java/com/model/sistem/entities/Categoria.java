package com.model.sistem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_categoria")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_linea")
	private Linea linea;
	
	private String descripcion;
	private String codigo;
	private String estado;
	private BigDecimal densidad;
    private BigDecimal gramajeDefinido;
    private String requiereEspesor;
    private BigDecimal precioUnitCotizacionDol;
}
