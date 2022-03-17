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

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_color")
	private Color color;
	
	private BigDecimal precio;
	private String tipoMonedaPrecio; //` char(1) DEFAULT 'D',
	private String estado;
	private String descripcionComercial;
	private BigDecimal pesoCalculado;
	private String tipoMedida;
	private String tipoMedidaEspesor;
	private BigDecimal ancho;
	private BigDecimal largo;
	private BigDecimal espesor;
	private BigDecimal espesorPulgada;
	private BigDecimal anchoPulgada;
	private BigDecimal largoPulgada;
	private BigDecimal anchoMilimetro;
	private BigDecimal largoMilimetro;
	private String textoImpresion;
	private String sellado;
	private String fuelle;
	private String adicional;
	private String estadoProductoVenta;
	private BigDecimal espesorGramoMt2;
	private BigDecimal anchoDesarrollo;
	private BigDecimal largoDesarrollo;
	private BigDecimal margenBalanzaKg;
	private BigDecimal millaresProyectadosPt;
	private BigDecimal kilosProyectadosPt;
	private BigDecimal metrosProyectadosPt;
	private Integer numeroBandas;
	private BigDecimal anchoUtilDesarrollo;
	private String tipoControlStock;
	private String tipoProductoVenta;
}
