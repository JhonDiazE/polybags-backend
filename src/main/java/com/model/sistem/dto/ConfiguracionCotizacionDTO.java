package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracionCotizacionDTO {

	private Integer id;
	private ParametroEstadoGeneralDTO parametroEstadoGeneral;
	private String descripcion;
    private String estado;
    private String tipoCliente;
    private String estadoImpresion;
}
