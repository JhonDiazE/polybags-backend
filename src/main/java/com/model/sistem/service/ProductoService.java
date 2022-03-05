package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Producto;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ProductoService {
	
	Producto findById(String id) throws ObjectNotFoundException;
	List<Producto> findAll();
	Producto save(Producto producto) ;
	List<Producto> saveAll(List<Producto> producto) ;
	void delete(String id) throws ObjectNotFoundException;
}
