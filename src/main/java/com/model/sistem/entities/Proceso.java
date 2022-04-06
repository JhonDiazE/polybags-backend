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
public class Proceso {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proceso")
	@Id
	private Integer id;
	
    private String descripcion;
    private String codigo;
    private String estado;
    
    /*
    private Empresa empresa;
    private String addManual;
    private String tipoBulto;
    private String requiereBultoAnterior;
    private String movimientoProduccion;
    private BigDecimal scrapNominalKg;
    private BigDecimal scrapNominalMl;
    private BigDecimal porcentajeInversion;
    private String descripcion2;
    private String estadoMovil;
    private BigDecimal costoMercadoKgProcesoChi;
    private BigDecimal costoMercadoKgProcesoLim;
    private Integer orden;
    private String estadoValidacionTinta;
    private String estadoValidacionAdhesivo;
    private Integer numberRowsForm;
    private BigDecimal metrosMermaRegulacionStandar;
    private BigDecimal porcentajeMermaOperacionalStandar;
    private String calcularPesoProbeta;
    private String plantillaReporte;
    private String plantillaReporteRegistro;
    private String diagramaEstaticoReporte;
    private String formaPlanificacion;
    private String styleClassPlanificacion;
    private String colorPlanificacion;
    private BigDecimal kilosMargenAdicionales;
    private String cdCodigo;
    private String cdFecha;
    private String cdVersion;
    private String estadoValidacionCalidad;
    private Integer numberRowsFormCalidad;
*/
}
