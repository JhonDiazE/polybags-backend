package com.model.sistem.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.Proceso;
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
public class DesarrolloEstructuraDTO {

	private Integer id;
	private Usuario usuario;
	private Usuario usuarioMod;
	private Categoria categoria;
	private Producto producto;
	private Proceso proceso;
	private BigDecimal densidad;
    private BigDecimal espesorMicras;
    private BigDecimal gramaje;
    private BigDecimal porcentajeEstructura;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private BigDecimal espesorMilPul;
    private Integer orden;
    private String estadoFijo;
    private BigDecimal anchoMm;
    private BigDecimal cantidadKilosNormal;
    private BigDecimal cantidadKilosRefile;
    private BigDecimal cantidadKilosConrefile;
    private BigDecimal cantidadMetrosPt;
    private BigDecimal cantidadMetrosRegulacionProceso;
    private BigDecimal cantidadMetrosMermaOperacional;
    private BigDecimal cantidadMetrosEntrada;
    private BigDecimal cantidadKilosRegulacion;
    private BigDecimal cantidadKilosMermaOperacional;
    private BigDecimal cantidadKilosEntradaTotal;
    private BigDecimal anchoAdicionalRefile;
}
