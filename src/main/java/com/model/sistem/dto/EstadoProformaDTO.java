package com.model.sistem.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoProformaDTO {

	private Long id;
	private ProformaDTO proforma;
	private String estado;
	private UsuarioDTO usuario;
	private Date fechaRegistro; 
}
