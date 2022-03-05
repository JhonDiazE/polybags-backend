package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Linea;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface LineaService {
	
	Linea findById(Integer id) throws ObjectNotFoundException;
	List<Linea> findAll();
	Linea save(Linea linea) ;
	List<Linea> saveAll(List<Linea> linea) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
