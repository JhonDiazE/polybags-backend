package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Linea;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.LineaRepository;
import com.model.sistem.service.LineaService;

@Service
public class LineaServiceImpl implements LineaService{
	
	@Autowired
	private LineaRepository lineaRepository;
	
	@Override
	public Linea findById(Integer id) throws ObjectNotFoundException {
		return  lineaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Linea> findAll() {
		return lineaRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Linea save(Linea linea) {
		return lineaRepository.save(linea);
	}
	
	@Override
	@Transactional()
	public List<Linea> saveAll(List<Linea> listTpoCambio) {
		return lineaRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Linea linea =  lineaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		lineaRepository.delete(linea);
	}
}
