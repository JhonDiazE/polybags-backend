package com.model.sistem.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.model.sistem.entities.DetalleRutaProceso;
import com.model.sistem.entities.Producto;
import com.model.sistem.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlMetrosKilosProductoDTO {

	  private Integer id;
	  private Producto producto;
	  private DetalleRutaProcesoDTO detalleRutaProceso;
//  private RutaProceso rutaProceso;
	  private Usuario usuario;
//  private Estacion estacion;
	  private Producto productoSalida;
	  private BigDecimal metrosProductoTerminado;
	  private BigDecimal metrosRegulacionProceso;
	  private BigDecimal metrosRegulacionSiguienteProceso;
	  private BigDecimal porcentajeMermaOperacional;
	  private BigDecimal metrosMermaOperacional;
	  private BigDecimal metrosMermaOperacionalSigProc;
	  private BigDecimal metrosEntradaTotal;
	  private BigDecimal metrosSalidaTotal;
	  private BigDecimal gramajeSalidaProceso;
	  private BigDecimal anchoMmSalidaProceso;
	  private BigDecimal kilosEntradaAlmacenProceso;
	  private BigDecimal kilosEntradaProcesoAnterior;
	  private BigDecimal kilosEntradaTotal;
	  private BigDecimal kilosSalidaProceso;
	  private BigDecimal porcentajeScrapTotal;
	  private String estado;
	  private Date fechaRegistro;
	  private BigDecimal pesoMinProbeta;
	  private BigDecimal pesoMaxProbeta;
	  private String observacionProceso1;
	  private String observacionProceso2;
	  private String observacionProceso3;
	  private String ubicacionBobinas;
	  private String tipoBulto;
	  private String graficoTratamiento;
	  private String cabecera1;
	  private String cabecera2;
	  private String cabecera3;
	  private String cabecera4;
	  private String cabecera5;
	  private String cabecera6;
	  private String cabecera7;
	  private String cabecera8;
	  private String dato1;
	  private String dato2;
	  private String dato3;
	  private String dato4;
	  private String dato5;
	  private String dato6;
	  private String dato7;
	  private String dato8;
}
