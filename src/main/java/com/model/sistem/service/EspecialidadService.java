package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface EspecialidadService {
	
	Especialidad findById(Integer id) throws ObjectNotFoundException;
	List<Especialidad> findByEstadoAndEstadoCamposPtAndEmpresa(String estado, String estadoCamposPt, Empresa empresa);
	List<Especialidad> findAll();
	Especialidad save(Especialidad especialidad) ;
	List<Especialidad> saveAll(List<Especialidad> especialidad) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
