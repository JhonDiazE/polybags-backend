package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	@Id
	private Integer id;
	
	private String nick;
	private String clave;
	private String estado;
}
