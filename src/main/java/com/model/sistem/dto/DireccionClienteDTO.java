package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DireccionClienteDTO {

	private Integer id;
	private String direccion;
	private String domicilioFiscal;
	private String estado;
	

}
