package com.model.sistem.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProformaDTO {

	private Long id;
	private String numero;
	private ClienteDTO cliente;
	private SucursalDTO sucursal;
	private VendedorDTO vendedor;
	private CondicionPagoDTO condicionPago;
	private ContactoClienteDTO contactoCliente;
	private DireccionClienteDTO direccionCliente;
	private UsuarioDTO usuario;
	private UsuarioDTO usuarioModificacion;
	private UsuarioDTO usuarioAprobacion;
	private Date fechaEmision;
	private String formaPago;
	private String tipoMoneda;
	private BigDecimal subTotal;
	private BigDecimal igv;
	private BigDecimal total;
	private String estado; // char(1) NOT NULL DEFAULT 'E' COMMENT 'E->EMITIDA,A->APROBADA,N->ENVIADA,O->CON OC,R->RECHAZADA,S->SIN RESPUESTA,I->INACTIVAS',
	private BigDecimal tasaCambio;
	private String direccionClienteFactura;
	private String tipoVenta; //` char(1) NOT NULL COMMENT 'P->PRODUCTO,S->SERVICIO',
	private Date fechaRegistro; //` datetime NOT NULL,
	private Date fechaModificacion; //` datetime DEFAULT NULL,
	private String observacion; //` char(250) DEFAULT NULL,
	private Date fechaAprobacion; //` datetime DEFAULT NULL,
	
	
}
