package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Proforma;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ProformaService {
	
	Proforma findById(Long id) throws ObjectNotFoundException;
	List<Proforma> findAll();
	Proforma save(Proforma proforma) ;
	List<Proforma> saveAll(List<Proforma> proforma) ;
	void delete(Long id) throws ObjectNotFoundException;
}
