package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.CondicionPago;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface CondicionPagoService {
	
	CondicionPago findById(Integer id) throws ObjectNotFoundException;
	List<CondicionPago> findAll();
	CondicionPago save(CondicionPago condicionPago) ;
	List<CondicionPago> saveAll(List<CondicionPago> condicionPago) ;
	void delete(Integer id) throws ObjectNotFoundException;
}