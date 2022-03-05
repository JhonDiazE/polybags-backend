package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Vendedor {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_vendedor")
	@Id
	private Integer id;
	
	private String nombre;
	private String dni;
	
	
}
