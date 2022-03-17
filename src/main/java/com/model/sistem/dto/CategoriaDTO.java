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
public class CategoriaDTO {

	private Integer id;
	private LineaDTO linea;
	private String descripcion;
	private String codigo;
	private String estado;
	private BigDecimal densidad;
}
