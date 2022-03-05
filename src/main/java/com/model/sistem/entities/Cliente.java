package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cliente {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cliente")
	@Id
	private Integer id;

	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="nombre_comercial")
	private String nombreComercial;
	
	private String ruc;
	private String dni;
	private String estado;
}
