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
public class Color {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_color")
	@Id
	private Integer id;
	
	private String descripcion;
	private String abreviatura;
	private String estado;
}
