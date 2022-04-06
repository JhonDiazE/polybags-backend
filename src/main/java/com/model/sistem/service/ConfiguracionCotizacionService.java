package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ConfiguracionCotizacionService {
	
	ConfiguracionCotizacion findById(Integer id) throws ObjectNotFoundException;
	List<ConfiguracionCotizacion> findAll();
	List<ConfiguracionCotizacion> findByEstadoNotAndParametroEstadoGeneralAndEstadoImpresionOrderByDescripcion(String estado, ParametroEstadoGeneral tablaParametro, String estadoImpresion);
	ConfiguracionCotizacion save(ConfiguracionCotizacion ConfiguracionCotizacion) ;
	List<ConfiguracionCotizacion> saveAll(List<ConfiguracionCotizacion> ConfiguracionCotizacion) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
