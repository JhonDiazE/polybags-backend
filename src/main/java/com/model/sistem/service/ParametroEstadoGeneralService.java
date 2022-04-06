package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Empresa;
import com.model.sistem.entities.Especialidad;
import com.model.sistem.entities.ParametroEstadoGeneral;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ParametroEstadoGeneralService {
	
	ParametroEstadoGeneral findById(Integer id) throws ObjectNotFoundException;
	List<ParametroEstadoGeneral> findAll();
	List<ParametroEstadoGeneral> findByEstadoAndTablaParametro(String estado, String tablaParametro);
	ParametroEstadoGeneral save(ParametroEstadoGeneral ParametroEstadoGeneral) ;
	List<ParametroEstadoGeneral> saveAll(List<ParametroEstadoGeneral> ParametroEstadoGeneral) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
