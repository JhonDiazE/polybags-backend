package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.DetalleProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface DetalleProformaService {
	
	DetalleProforma findById(Long id) throws ObjectNotFoundException;
	List<DetalleProforma> findAll();
	DetalleProforma save(DetalleProforma detalleProforma) ;
	List<DetalleProforma> saveAll(List<DetalleProforma> detalleProforma);
	void delete(Long id) throws ObjectNotFoundException;
}
