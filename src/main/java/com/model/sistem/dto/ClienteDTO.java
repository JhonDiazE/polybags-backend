package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private Integer id;
	private String razonSocial;
	private String nombreComercial;
	private String ruc;
	private String dni;
	private String estado;
}
