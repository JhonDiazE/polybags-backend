package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutaProcesoDTO {

	private Integer id;
    private ProcesoDTO proceso;
    private ProcesoDTO procesoSiguiente;
	private RutaProcesoDTO rutaProceso;
	private Integer secuencia;
    private Integer numeroProcesoSiguiente;
    private Integer numeroProceso;
    private String estado;
}
