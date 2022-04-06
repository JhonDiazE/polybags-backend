package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.DetalleConfiguracionCotizacion;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface DetalleConfiguracionCotizacionService {
	
	DetalleConfiguracionCotizacion findById(Long id) throws ObjectNotFoundException;
	List<DetalleConfiguracionCotizacion> findAll();
	List<DetalleConfiguracionCotizacion> findByConfiguracionCotizacion(ConfiguracionCotizacion configuracionCotizacion);
	DetalleConfiguracionCotizacion save(DetalleConfiguracionCotizacion detalleConfiguracionCotizacion) ;
	List<DetalleConfiguracionCotizacion> saveAll(List<DetalleConfiguracionCotizacion> detalleConfiguracionCotizacion);
	void delete(Long id) throws ObjectNotFoundException;
}
