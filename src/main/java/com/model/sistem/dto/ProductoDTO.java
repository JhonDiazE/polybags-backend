package com.model.sistem.dto;

import java.math.BigDecimal;

import com.model.sistem.entities.ParametroEstadoGeneral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
	
	private String id;
	private String descripcion;
	private UnidadDTO unidad;
	private LineaDTO linea;
	private ColorDTO color;
	private CategoriaDTO categoria;
	private ParametroEstadoGeneralDTO parametroEstadoGeneralCotizacion;
	private BigDecimal precio;
	private String tipoMonedaPrecio; //` char(1) DEFAULT 'D',
	private String estado;
	private String descripcionComercial;
	private BigDecimal pesoCalculado;
	private String tipoMedida;
	private String tipoMedidaEspesor;
	private BigDecimal ancho;
	private BigDecimal largo;
	private BigDecimal espesor;
	private BigDecimal espesorPulgada;
	private BigDecimal anchoPulgada;
	private BigDecimal largoPulgada;
	private BigDecimal anchoMilimetro;
	private BigDecimal largoMilimetro;
	private String textoImpresion;
	private String sellado;
	private String fuelle;
	private String adicional;
	private String estadoProductoVenta;
	private BigDecimal espesorGramoMt2;
	private BigDecimal anchoDesarrollo;
	private BigDecimal largoDesarrollo;
	private BigDecimal margenBalanzaKg;
	private BigDecimal millaresProyectadosPt;
	private BigDecimal kilosProyectadosPt;
	private BigDecimal metrosProyectadosPt;
	private Integer numeroBandas;
	private BigDecimal anchoUtilDesarrollo;
	private String tipoControlStock;
	private String tipoProductoVenta;
	private BigDecimal pesoZipperUnd;
	private BigDecimal pesoValvulaUnd;
	private BigDecimal pesoCalculadoAdicional;
	private String formaSustratoDesarrollo;
	private BigDecimal anchoImpresion;
	private BigDecimal frecuenciaImpresion;
	private BigDecimal anchoBandaImpresion;
	private BigDecimal largoRepeticionImpresion;
	private Integer numeroRepeticiones;
	private String impresion;
	private String numeroCilindro;
	private Integer numeroColores;
	private String tipoImpresion;
	private String estadoZipper;
	private String estadoValvula;
}
