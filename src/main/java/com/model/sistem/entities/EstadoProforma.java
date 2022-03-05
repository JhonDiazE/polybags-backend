package com.model.sistem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class EstadoProforma {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_estado_proforma")
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_proforma")
	private Proforma proforma;
	
	@Column(length = 20)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro; 
}
