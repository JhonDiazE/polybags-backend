package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Vendedor;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.VendedorRepository;
import com.model.sistem.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public Vendedor findById(Integer id) throws ObjectNotFoundException {
		return  vendedorRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Vendedor> findAll() {
		return vendedorRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Vendedor save(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@Override
	@Transactional()
	public List<Vendedor> saveAll(List<Vendedor> listTpoCambio) {
		return vendedorRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Vendedor vendedor =  vendedorRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		vendedorRepository.delete(vendedor);
	}
}
