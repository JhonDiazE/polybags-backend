package com.model.sistem.service;

import java.util.List;
import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.Linea;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface CategoriaService {
	
	Categoria findById(Integer id) throws ObjectNotFoundException;
	List<Categoria> findByEstadoAndLinea(Linea linea);
	List<Categoria> findAll();
	Categoria save(Categoria categoria) ;
	List<Categoria> saveAll(List<Categoria> categoria) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
