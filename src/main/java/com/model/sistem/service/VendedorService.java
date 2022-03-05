package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Vendedor;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface VendedorService {
	
	Vendedor findById(Integer id) throws ObjectNotFoundException;
	List<Vendedor> findAll();
	Vendedor save(Vendedor cliente) ;
	List<Vendedor> saveAll(List<Vendedor> cliente) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
