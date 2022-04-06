package com.model.sistem.dto;

import java.math.BigDecimal;

import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.Proceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleConfiguracionCotizacionDTO {
	
	private Long id;
	private Categoria categoria;
	private ConfiguracionCotizacion configuracionCotizacion;
	private String estado;
	private Proceso proceso;
	private BigDecimal anchoAdicionalRefile;

}
