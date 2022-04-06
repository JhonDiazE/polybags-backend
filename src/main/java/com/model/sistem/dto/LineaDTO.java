package com.model.sistem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineaDTO {
	
	private Integer id;
	private String descripcion;
	private UnidadDTO unidadDefault;
	private EspecialidadDTO especialidad;
	private EmpresaDTO empresa;
	private String codigo;
	private String estado;
	private String estadoParametroPlastico;
	private String estadoStockLote;
	private String estadoStockItem;
	private boolean productoVenta;
	private String tipoProductoVenta;
}
