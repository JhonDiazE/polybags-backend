package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.ConfiguracionCotizacion;
import com.model.sistem.entities.DetalleConfiguracionCotizacion;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.DetalleConfiguracionCotizacionRepository;
import com.model.sistem.service.DetalleConfiguracionCotizacionService;

@Service
public class DetalleConfiguracionCotizacionServiceImpl implements DetalleConfiguracionCotizacionService{
	
	@Autowired
	private DetalleConfiguracionCotizacionRepository detalleConfiguracionCotizacionRepository;
	
	@Override
	public DetalleConfiguracionCotizacion findById(Long id) throws ObjectNotFoundException {
		return  detalleConfiguracionCotizacionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<DetalleConfiguracionCotizacion> findAll() {
		return detalleConfiguracionCotizacionRepository.findAll();
	}
	
	@Override
	public List<DetalleConfiguracionCotizacion> findByConfiguracionCotizacion(ConfiguracionCotizacion configuracionCotizacion){
		return detalleConfiguracionCotizacionRepository.findByConfiguracionCotizacion(configuracionCotizacion);
	}
	
	@Override
	@Transactional()
	public DetalleConfiguracionCotizacion save(DetalleConfiguracionCotizacion detalleConfiguracionCotizacion) {
		return detalleConfiguracionCotizacionRepository.save(detalleConfiguracionCotizacion);
	}
	
	@Override
	@Transactional()
	public List<DetalleConfiguracionCotizacion> saveAll(List<DetalleConfiguracionCotizacion> listTpoCambio) {
		return detalleConfiguracionCotizacionRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Long id) throws ObjectNotFoundException {
		DetalleConfiguracionCotizacion detalleConfiguracionCotizacion =  detalleConfiguracionCotizacionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		detalleConfiguracionCotizacionRepository.delete(detalleConfiguracionCotizacion);
	}
}
