package com.model.sistem.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleProformaDTO {
	
	private Long id;
	private ProductoDTO producto;
	private UnidadDTO unidad;
	private ProformaDTO proforma;
	private BigDecimal factorVenta;
	private BigDecimal precioUnitario;
	private BigDecimal cantidad;
	private BigDecimal totalVenta;
	private BigDecimal pesoTotal;
	private BigDecimal costoUnitarioMpDolares;
	private BigDecimal costoUnitarioModDolares;
	private BigDecimal costoUnitarioCifDolares;
	private BigDecimal costoUnitarioAdminDolares;
	private BigDecimal costoUnitarioVentaDolares;
	private BigDecimal costoUnitarioFinancieroDolares;
	private BigDecimal costoTotalMpDolares;
	private BigDecimal costoTotalModDolares;
	private BigDecimal costoTotalCifDolares;
	private BigDecimal costoTotalAdminDolares;
	private BigDecimal costoTotalVentaDolares;
	private BigDecimal costoTotalFinancieroDolares;
	private BigDecimal costoTotalAccesoriosDolares;
	private BigDecimal costoTotalDolares;
	private BigDecimal costoUnitarioKilogramoDolares;
	private BigDecimal costoUnitarioMillarDolares;
	private BigDecimal porcentajeUtilidad;
	private BigDecimal utilidadProyectada;

}
