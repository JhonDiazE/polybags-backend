package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.EstadoProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.EstadoProformaRepository;
import com.model.sistem.service.EstadoProformaService;

@Service
public class EstadoProformaServiceImpl implements EstadoProformaService{
	
	@Autowired
	private EstadoProformaRepository estadoProformaRepository;
	
	@Override
	public EstadoProforma findById(Long id) throws ObjectNotFoundException {
		return  estadoProformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	
	@Override
	public List<EstadoProforma> findAll() {
		return estadoProformaRepository.findAll();
	}
	
	@Override
	@Transactional()
	public EstadoProforma save(EstadoProforma estadoProforma) {
		return estadoProformaRepository.save(estadoProforma);
	}
	
	@Override
	@Transactional()
	public List<EstadoProforma> saveAll(List<EstadoProforma> listTpoCambio) {
		return estadoProformaRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Long id) throws ObjectNotFoundException {
		EstadoProforma estadoProforma =  estadoProformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		estadoProformaRepository.delete(estadoProforma);
	}
}
