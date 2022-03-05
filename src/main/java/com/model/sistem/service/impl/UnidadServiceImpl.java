package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Unidad;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.UnidadRepository;
import com.model.sistem.service.UnidadService;

@Service
public class UnidadServiceImpl implements UnidadService{
	
	@Autowired
	private UnidadRepository unidadRepository;
	
	@Override
	public Unidad findById(Integer id) throws ObjectNotFoundException {
		return  unidadRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Unidad> findAll() {
		return unidadRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Unidad save(Unidad unidad) {
		return unidadRepository.save(unidad);
	}
	
	@Override
	@Transactional()
	public List<Unidad> saveAll(List<Unidad> listTpoCambio) {
		return unidadRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Unidad unidad =  unidadRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		unidadRepository.delete(unidad);
	}
}
