package com.model.sistem.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Proforma {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proforma")
	@Id
	private Long id;
	
	@Column(length = 20)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;
	
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn(name = "id_condicion_pago")
	private CondicionPago condicionPago;
	
	@ManyToOne
	@JoinColumn(name = "id_contacto_cliente")
	private ContactoCliente contactoCliente;
		
	@ManyToOne
	@JoinColumn(name = "id_direccion_cliente")
	private DireccionCliente direccionCliente;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_modificacion")
	private Usuario usuarioModificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_aprobacion")
	private Usuario usuarioAprobacion;
	
	@Column(name="fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column(name="forma_pago", length = 20)
	private String formaPago;
	
	@Column(name="tipo_moneda", length = 20)
	private String tipoMoneda;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal subTotal;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal igv;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal total;
	
	@Column(length = 20)
	private String estado; // char(1) NOT NULL DEFAULT 'E' COMMENT 'E->EMITIDA,A->APROBADA,N->ENVIADA,O->CON OC,R->RECHAZADA,S->SIN RESPUESTA,I->INACTIVAS',
	
	@Column(precision = 10, scale = 3)
	private BigDecimal tasaCambio;
	
	@Column(length = 300)
	private String direccionClienteFactura;
	
	@Column(length = 20)
	private String tipoVenta; //` char(1) NOT NULL COMMENT 'P->PRODUCTO,S->SERVICIO',
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro; //` datetime NOT NULL,
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion; //` datetime DEFAULT NULL,
	
	@Column(length = 300)
	private String observacion; //` char(250) DEFAULT NULL,
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacion; //` datetime DEFAULT NULL,
	
	
}
