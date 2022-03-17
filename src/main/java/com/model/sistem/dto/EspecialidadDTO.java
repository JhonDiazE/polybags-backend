package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadDTO {

	private Integer id;
	private EmpresaDTO empresa;
	private String estadoCamposPt;
	private String descripcion;
	private String codigo;
	private String estado;
}
