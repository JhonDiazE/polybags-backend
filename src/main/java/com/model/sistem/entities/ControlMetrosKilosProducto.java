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

import lombok.Data;

@Entity
@Data
public class ControlMetrosKilosProducto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcontrolmetroskilosproducto")
	@Id
	private Integer id;

    @ManyToOne
    @JoinColumn(name = "iddetallerutaproceso")
    private DetalleRutaProceso detalleRutaProceso;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

//    @ManyToOne
//    @JoinColumn(name = "idrutaproceso")
//    private RutaProceso rutaProceso;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

//    @ManyToOne
//    @JoinColumn(name = "idestacion")
//    private Estacion estacion;

    @ManyToOne
    @JoinColumn(name = "idproductosalida")
    private Producto productoSalida;

    @Column(name = "metrosproductoterminado")
    private BigDecimal metrosProductoTerminado;

    @Column(name = "metrosregulacionproceso")
    private BigDecimal metrosRegulacionProceso;

    @Column(name = "metrosregulacionsiguienteproceso")
    private BigDecimal metrosRegulacionSiguienteProceso;

    @Column(name = "porcentajemermaoperacional")
    private BigDecimal porcentajeMermaOperacional;

    @Column(name = "metrosmermaoperacional")
    private BigDecimal metrosMermaOperacional;

    @Column(name = "metrosmermaoperacionalsigProc")
    private BigDecimal metrosMermaOperacionalSigProc;

    @Column(name = "metrosentradatotal")
    private BigDecimal metrosEntradaTotal;

    @Column(name = "metrossalidatotal")
    private BigDecimal metrosSalidaTotal;

    @Column(name = "gramajesalidaproceso")
    private BigDecimal gramajeSalidaProceso;

    @Column(name = "anchommsalidaproceso")
    private BigDecimal anchoMmSalidaProceso;

    @Column(name = "kilosentradaalmacenproceso")
    private BigDecimal kilosEntradaAlmacenProceso;

    @Column(name = "kilosentradaprocesoanterior")
    private BigDecimal kilosEntradaProcesoAnterior;

    @Column(name = "kilosentradatotal")
    private BigDecimal kilosEntradaTotal;

    @Column(name = "kilossalidaproceso")
    private BigDecimal kilosSalidaProceso;

    @Column(name = "porcentajescraptotal")
    private BigDecimal porcentajeScrapTotal;

    private String estado;

    @Column(name = "fecharegistro")
    private Date fechaRegistro;

    @Column(name = "pesominprobeta")
    private BigDecimal pesoMinProbeta;

    @Column(name = "pesomaxprobeta")
    private BigDecimal pesoMaxProbeta;

    @Column(name = "observacionproceso1")
    private String observacionProceso1;

    @Column(name = "observacionproceso2")
    private String observacionProceso2;

    @Column(name = "observacionproceso3")
    private String observacionProceso3;

    @Column(name = "ubicacionbobinas")
    private String ubicacionBobinas;

    @Column(name = "tipobulto")
    private String tipoBulto;

    @Column(name = "graficotratamiento")
    private String graficoTratamiento;

    private String cabecera1;
    private String cabecera2;
    private String cabecera3;
    private String cabecera4;
    private String cabecera5;
    private String cabecera6;
    private String cabecera7;
    private String cabecera8;
    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;
    private String dato5;
    private String dato6;
    private String dato7;
    private String dato8;

}
