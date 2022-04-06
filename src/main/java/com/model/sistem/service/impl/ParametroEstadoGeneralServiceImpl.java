package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ParametroEstadoGeneralRepository;
import com.model.sistem.service.ParametroEstadoGeneralService;

@Service
public class ParametroEstadoGeneralServiceImpl implements ParametroEstadoGeneralService{
	
	@Autowired
	private ParametroEstadoGeneralRepository parametroEstadoGeneralRepository;
	
	@Override
	public ParametroEstadoGeneral findById(Integer id) throws ObjectNotFoundException {
		return  parametroEstadoGeneralRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<ParametroEstadoGeneral> findByEstadoAndTablaParametro(String estado, String tablaParametro){
		return parametroEstadoGeneralRepository.findByEstadoAndTablaParametro(estado, tablaParametro);
	}

	@Override
	public List<ParametroEstadoGeneral> findAll() {
		return parametroEstadoGeneralRepository.findAll();
	}
	
	@Override
	@Transactional()
	public ParametroEstadoGeneral save(ParametroEstadoGeneral ParametroEstadoGeneral) {
		return parametroEstadoGeneralRepository.save(ParametroEstadoGeneral);
	}
	
	@Override
	@Transactional()
	public List<ParametroEstadoGeneral> saveAll(List<ParametroEstadoGeneral> listTpoCambio) {
		return parametroEstadoGeneralRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		ParametroEstadoGeneral ParametroEstadoGeneral =  parametroEstadoGeneralRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		parametroEstadoGeneralRepository.delete(ParametroEstadoGeneral);
	}
}
