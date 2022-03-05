package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.ContactoCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ContactoClienteRepository;
import com.model.sistem.service.ContactoClienteService;

@Service
public class ContactoClienteServiceImpl implements ContactoClienteService{
	
	@Autowired
	private ContactoClienteRepository contactoClienteRepository;
	
	@Override
	public ContactoCliente findById(Integer id)  throws ObjectNotFoundException{
		return  contactoClienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<ContactoCliente> findAll() {
		return contactoClienteRepository.findAll();
	}
	
	@Override
	@Transactional()
	public ContactoCliente save(ContactoCliente contactoCliente) {
		return contactoClienteRepository.save(contactoCliente);
	}
	
	@Override
	@Transactional()
	public List<ContactoCliente> saveAll(List<ContactoCliente> listTpoCambio) {
		return contactoClienteRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id)  throws ObjectNotFoundException{
		ContactoCliente contactoCliente =  contactoClienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		contactoClienteRepository.delete(contactoCliente);
	}
}
