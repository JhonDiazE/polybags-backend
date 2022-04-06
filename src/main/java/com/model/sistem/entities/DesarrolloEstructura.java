package com.model.sistem.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DesarrolloEstructura {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_desarrollo_estructura")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_mod")
    private Usuario usuarioMod;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria_estructura")
    private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
    private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_proceso")
    private Proceso proceso;
	
    private BigDecimal densidad;
    private BigDecimal espesorMicras;
    private BigDecimal gramaje;
    private BigDecimal porcentajeEstructura;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private BigDecimal espesorMilPul;
    private Integer orden;
    private String estadoFijo;
    private BigDecimal anchoMm;
    private BigDecimal cantidadKilosNormal;
    private BigDecimal cantidadKilosRefile;
    private BigDecimal cantidadKilosConrefile;
    private BigDecimal cantidadMetrosPt;
    private BigDecimal cantidadMetrosRegulacionProceso;
    private BigDecimal cantidadMetrosMermaOperacional;
    private BigDecimal cantidadMetrosEntrada;
    private BigDecimal cantidadKilosRegulacion;
    private BigDecimal cantidadKilosMermaOperacional;
    private BigDecimal cantidadKilosEntradaTotal;
    private BigDecimal anchoAdicionalRefile;
}
