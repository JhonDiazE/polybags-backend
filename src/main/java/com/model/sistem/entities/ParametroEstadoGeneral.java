package com.model.sistem.entities;

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
public class ParametroEstadoGeneral {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_parametro_estado_general")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
//	@ManyToOne
//	@JoinColumn(name = "id_proceso")
//	private Proceso proceso;
	
//	@ManyToOne
//	@JoinColumn(name = "id_sucursal")
//	private Sucursal sucursal;
	
	private String codigo;
    private String descripcion;
    private String tablaParametro;
    private String periodo;
    private String tipoProducto;
    private String estado;
    private String icono;
    private Integer numeroCapas;
    private String link;
    private String plantilla;
    private String cabecera;
    private String color;
    
    @Column(name = "diasentregaproyectada")
    private Integer diasEntregaProyectada;
	
}
