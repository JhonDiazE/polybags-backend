package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroEstadoGeneralDTO {
	
	private Integer id;
//	private SucursalDTO sucursal;
	private EmpresaDTO empresa;
	private String codigo;
    private String descripcion;
    private String tablaParametro;
    private String periodo;
    private String tipoProducto;
    private String estado;
    private String icono;
    private Integer numeroCapas;
    private String link;
    private String plantilla;
    private String cabecera;
    private String color;
    private Integer diasEntregaProyectada;
		
}
