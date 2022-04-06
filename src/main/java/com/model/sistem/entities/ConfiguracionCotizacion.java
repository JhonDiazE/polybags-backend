package com.model.sistem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ConfiguracionCotizacion {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_configuracion_cotizacion")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_parametro_estado_general")
	private ParametroEstadoGeneral parametroEstadoGeneral;
	
    private String descripcion;
    private String estado;
    private String tipoCliente;
    private String estadoImpresion;
	

}
