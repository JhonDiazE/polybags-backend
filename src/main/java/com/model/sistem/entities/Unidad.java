package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Unidad {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_unidad")
	@Id
	private Integer id;
	
	private String descripcion;
	private String abreviatura;
}
