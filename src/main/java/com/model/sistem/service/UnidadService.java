package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Unidad;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface UnidadService {
	
	Unidad findById(Integer id) throws ObjectNotFoundException;
	List<Unidad> findAll();
	Unidad save(Unidad unidad) ;
	List<Unidad> saveAll(List<Unidad> unidad) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
