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
public class Linea {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_linea")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "id_especialidad")
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "id_unidad_default")
	private Unidad unidadDefault;
	
	private String descripcion;
	private String codigo;
	private String estado;
	private String estadoParametroPlastico;
	private String estadoStockLote;
	private String estadoStockItem;
	private boolean productoVenta;
	private String tipoProductoVenta;
	
	public Linea(Integer id) {
		this.id = id;
	}
	
	
}
