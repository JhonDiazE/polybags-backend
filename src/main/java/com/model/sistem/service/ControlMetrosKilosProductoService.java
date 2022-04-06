package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.ControlMetrosKilosProducto;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ControlMetrosKilosProductoService {
	
	ControlMetrosKilosProducto findById(Integer id) throws ObjectNotFoundException;
	List<ControlMetrosKilosProducto> findAll();
	ControlMetrosKilosProducto save(ControlMetrosKilosProducto controlMetrosKilosProducto) ;
	List<ControlMetrosKilosProducto> saveAll(List<ControlMetrosKilosProducto> controlMetrosKilosProducto) ;
	void delete(Integer id) throws ObjectNotFoundException;
}