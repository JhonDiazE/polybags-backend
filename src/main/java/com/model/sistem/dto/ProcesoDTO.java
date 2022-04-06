package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoDTO {

	private Integer id;
	private String descripcion;
	private String abreviatura;
	private String estado;
}
