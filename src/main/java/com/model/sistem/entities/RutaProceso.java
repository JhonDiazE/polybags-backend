package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ruta_proceso")
public class RutaProceso {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_detalle_ruta_proceso")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_proceso")
    private Proceso proceso;
	
	@ManyToOne
	@JoinColumn(name = "id_proceso_siguiente")
    private Proceso procesoSiguiente;
	
	@ManyToOne
	@JoinColumn(name = "id_ruta_proceso")
	private RutaProceso rutaProceso;
    
	private Integer secuencia;
    private Integer numeroProcesoSiguiente;
    private Integer numeroProceso;
    private String estado;
    
}
