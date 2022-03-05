package com.model.sistem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DetalleProforma {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_detalle_proforma")
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_unidad")
	private Unidad unidad;
	
	@ManyToOne
	@JoinColumn(name = "id_proforma")
	private Proforma proforma;

	@Column(precision=10, scale=3)
	private BigDecimal factorVenta;
	
	@Column(precision=10, scale=3)
	private BigDecimal precioUnitario;
	
	@Column(precision=10, scale=2)
	private BigDecimal cantidad;
	
	@Column(precision=10, scale=2)
	private BigDecimal totalVenta;

	@Column(precision=10, scale=2)
	private BigDecimal pesoTotal;
	
	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioMpDolares;
	
	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioModDolares;

	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioCifDolares;

	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioAdminDolares;
	
	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioVentaDolares;
	
	@Column(precision=10, scale=3)
	private BigDecimal costoUnitarioFinancieroDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalMpDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalModDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalCifDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalAdminDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalVentaDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalFinancieroDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalAccesoriosDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoTotalDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoUnitarioKilogramoDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal costoUnitarioMillarDolares;
	
	@Column(precision=10, scale=2)
	private BigDecimal porcentajeUtilidad;
	
	@Column(precision=10, scale=2)
	private BigDecimal utilidadProyectada;
	
	

}
