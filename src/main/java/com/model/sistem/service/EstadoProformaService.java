package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.EstadoProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface EstadoProformaService {
	
	EstadoProforma findById(Long id) throws ObjectNotFoundException;
	List<EstadoProforma> findAll();
	EstadoProforma save(EstadoProforma estadoProforma) ;
	List<EstadoProforma> saveAll(List<EstadoProforma> estadoProforma) ;
	void delete(Long id) throws ObjectNotFoundException;
}
