package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Proforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ProformaRepository;
import com.model.sistem.service.ProformaService;

@Service
public class ProformaServiceImpl implements ProformaService{
	
	@Autowired
	private ProformaRepository proformaRepository;
	
	@Override
	public Proforma findById(Long id) throws ObjectNotFoundException {
		return  proformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Proforma> findAll() {
		return proformaRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Proforma save(Proforma proforma) {
		return proformaRepository.save(proforma);
	}
	
	@Override
	@Transactional()
	public List<Proforma> saveAll(List<Proforma> listTpoCambio) {
		return proformaRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Long id) throws ObjectNotFoundException {
		Proforma proforma =  proformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		proformaRepository.delete(proforma);
	}
}
