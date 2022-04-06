package com.model.sistem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.ParametroEstadoGeneral;

public interface ConfiguracionCotizacionRepository  extends JpaRepository<ConfiguracionCotizacion, Integer>{

	List<ConfiguracionCotizacion> findByEstadoNotAndParametroEstadoGeneralAndEstadoImpresionOrderByDescripcion(String estado, ParametroEstadoGeneral tablaParametro, String estadoImpresion);

}
