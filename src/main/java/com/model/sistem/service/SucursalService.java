package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Sucursal;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface SucursalService {
	
	Sucursal findById(Integer id) throws ObjectNotFoundException;
	List<Sucursal> findAll();
	Sucursal save(Sucursal sucursal) ;
	List<Sucursal> saveAll(List<Sucursal> sucursal) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
