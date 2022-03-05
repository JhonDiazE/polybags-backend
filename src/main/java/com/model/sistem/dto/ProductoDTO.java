package com.model.sistem.dto;

import java.math.BigDecimal;

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
	private BigDecimal precio;
	private String tipoMonedaPrecio; //` char(1) DEFAULT 'D',
	private String estado;
	
}
