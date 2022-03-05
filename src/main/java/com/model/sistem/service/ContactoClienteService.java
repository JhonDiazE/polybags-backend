package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.ContactoCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface ContactoClienteService {
	
	ContactoCliente findById(Integer id) throws ObjectNotFoundException;
	List<ContactoCliente> findAll();
	ContactoCliente save(ContactoCliente contactoCliente) ;
	List<ContactoCliente> saveAll(List<ContactoCliente> contactoCliente) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
