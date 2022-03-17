package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.EspecialidadRepository;
import com.model.sistem.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Especialidad findById(Integer id) throws ObjectNotFoundException {
		return  especialidadRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Especialidad> findAll() {
		return especialidadRepository.findAll();
	}
	
	@Override
	public List<Especialidad> findByEstadoAndEstadoCamposPtAndEmpresa(String estado, String estadoCamposPt, Empresa empresa){
		return especialidadRepository.findByEstadoAndEstadoCamposPtAndEmpresa(estado, estadoCamposPt, empresa);
	}
	
	@Override
	@Transactional()
	public Especialidad save(Especialidad especialidad) {
		return especialidadRepository.save(especialidad);
	}
	
	@Override
	@Transactional()
	public List<Especialidad> saveAll(List<Especialidad> listTpoCambio) {
		return especialidadRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Especialidad especialidad =  especialidadRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		especialidadRepository.delete(especialidad);
	}
}
