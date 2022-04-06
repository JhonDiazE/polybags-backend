package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ConfiguracionCotizacionRepository;
import com.model.sistem.service.ConfiguracionCotizacionService;

@Service
public class ConfiguracionCotizacionServiceImpl implements ConfiguracionCotizacionService{
	
	@Autowired
	private ConfiguracionCotizacionRepository configuracionCotizacionRepository;
	
	@Override
	public ConfiguracionCotizacion findById(Integer id) throws ObjectNotFoundException {
		return  configuracionCotizacionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<ConfiguracionCotizacion> findByEstadoNotAndParametroEstadoGeneralAndEstadoImpresionOrderByDescripcion(String estado, ParametroEstadoGeneral tablaParametro, String estadoImpresion){
		return configuracionCotizacionRepository.findByEstadoNotAndParametroEstadoGeneralAndEstadoImpresionOrderByDescripcion(estado, tablaParametro, estadoImpresion);
	}

	@Override
	public List<ConfiguracionCotizacion> findAll() {
		return configuracionCotizacionRepository.findAll();
	}
	
	@Override
	@Transactional()
	public ConfiguracionCotizacion save(ConfiguracionCotizacion ConfiguracionCotizacion) {
		return configuracionCotizacionRepository.save(ConfiguracionCotizacion);
	}
	
	@Override
	@Transactional()
	public List<ConfiguracionCotizacion> saveAll(List<ConfiguracionCotizacion> listTpoCambio) {
		return configuracionCotizacionRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		ConfiguracionCotizacion ConfiguracionCotizacion =  configuracionCotizacionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		configuracionCotizacionRepository.delete(ConfiguracionCotizacion);
	}
}
