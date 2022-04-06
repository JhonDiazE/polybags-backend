package com.model.sistem.service;

import java.util.List;
import com.model.sistem.entities.DesarrolloEstructura;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface DesarrolloEstructuraService {
	
	DesarrolloEstructura findById(Integer id) throws ObjectNotFoundException;
	List<DesarrolloEstructura> findAll();
	DesarrolloEstructura save(DesarrolloEstructura desarrolloEstructura) ;
	List<DesarrolloEstructura> saveAll(List<DesarrolloEstructura> desarrolloEstructura) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
