package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.CondicionPago;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.CondicionPagoRepository;
import com.model.sistem.service.CondicionPagoService;

@Service
public class CondicionPagoServiceImpl implements CondicionPagoService{
	
	@Autowired
	private CondicionPagoRepository condicionPagoRepository;
	
	@Override
	public CondicionPago findById(Integer id) throws ObjectNotFoundException {
		return  condicionPagoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<CondicionPago> findAll() {
		return condicionPagoRepository.findAll();
	}
	
	@Override
	@Transactional()
	public CondicionPago save(CondicionPago condicionPago) {
		return condicionPagoRepository.save(condicionPago);
	}
	
	@Override
	@Transactional()
	public List<CondicionPago> saveAll(List<CondicionPago> listTpoCambio) {
		return condicionPagoRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		CondicionPago condicionPago =  condicionPagoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		condicionPagoRepository.delete(condicionPago);
	}
}
