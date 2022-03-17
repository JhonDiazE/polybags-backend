package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_empresa")
	@Id
	private Integer id;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	private String ruc;

	public Empresa(Integer id) {
		this.id = id;
	}
	
	
}
