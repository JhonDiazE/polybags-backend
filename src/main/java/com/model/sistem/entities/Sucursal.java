package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sucursal {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_sucursal")
	@Id
	private Integer id;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	private String nombre;
}
