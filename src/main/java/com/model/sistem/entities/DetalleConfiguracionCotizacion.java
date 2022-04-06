package com.model.sistem.entities;

import java.math.BigDecimal;

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
public class DetalleConfiguracionCotizacion {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_detalle_configuracion_cotizacion")
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
    private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_configuracion_cotizacion")
    private ConfiguracionCotizacion configuracionCotizacion;
	
    private String estado;
    
	@ManyToOne
	@JoinColumn(name = "idproceso")
    private Proceso proceso;
	
    private BigDecimal anchoAdicionalRefile;
}
