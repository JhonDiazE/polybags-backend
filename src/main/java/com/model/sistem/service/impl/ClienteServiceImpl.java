package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Cliente;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ClienteRepository;
import com.model.sistem.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente findById(Integer id) throws ObjectNotFoundException {
		return  clienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	@Transactional()
	public List<Cliente> saveAll(List<Cliente> listTpoCambio) {
		return clienteRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Cliente cliente =  clienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		clienteRepository.delete(cliente);
	}
}
