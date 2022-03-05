package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.DireccionCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.DireccionClienteRepository;
import com.model.sistem.service.DireccionClienteService;

@Service
public class DireccionClienteServiceImpl implements DireccionClienteService{
	
	@Autowired
	private DireccionClienteRepository direccionClienteRepository;
	
	@Override
	public DireccionCliente findById(Integer id) throws ObjectNotFoundException {
		return  direccionClienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<DireccionCliente> findAll() {
		return direccionClienteRepository.findAll();
	}
	
	@Override
	@Transactional()
	public DireccionCliente save(DireccionCliente direccionCliente) {
		return direccionClienteRepository.save(direccionCliente);
	}
	
	@Override
	@Transactional()
	public List<DireccionCliente> saveAll(List<DireccionCliente> listTpoCambio) {
		return direccionClienteRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		DireccionCliente direccionCliente =  direccionClienteRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		direccionClienteRepository.delete(direccionCliente);
	}
}
