package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "contacto_proveedor")
public class ContactoCliente {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_contacto_proveedor")
	@Id
	private Integer id;
	
	private String nombres;
	private String email;
	private String estado;
}
