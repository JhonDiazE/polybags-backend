package com.model.sistem.service;

import java.util.List;
import com.model.sistem.entities.Cliente;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ClienteService {
	
	Cliente findById(Integer id) throws ObjectNotFoundException;
	List<Cliente> findAll();
	Cliente save(Cliente cliente) ;
	List<Cliente> saveAll(List<Cliente> cliente) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
