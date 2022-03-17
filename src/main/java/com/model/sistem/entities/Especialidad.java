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
public class Especialidad {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_especialidad")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@Column(name="estado_campos_pt")
	private String estadoCamposPt;
	
	private String descripcion;
	private String codigo;
	private String estado;
	
	public Especialidad(Integer id) {
		this.id = id;
	}
		
	
}
