package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.DireccionCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface DireccionClienteService {
	
	DireccionCliente findById(Integer id) throws ObjectNotFoundException;
	List<DireccionCliente> findAll();
	DireccionCliente save(DireccionCliente direccionCliente) ;
	List<DireccionCliente> saveAll(List<DireccionCliente> direccionCliente) ;
	void delete(Integer id) throws ObjectNotFoundException ;
}
