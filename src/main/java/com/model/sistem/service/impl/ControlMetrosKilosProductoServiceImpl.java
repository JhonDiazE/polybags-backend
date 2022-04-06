package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.ControlMetrosKilosProducto;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ControlMetrosKilosProductoRepository;
import com.model.sistem.service.ControlMetrosKilosProductoService;

@Service
public class ControlMetrosKilosProductoServiceImpl implements ControlMetrosKilosProductoService{
	
	@Autowired
	private ControlMetrosKilosProductoRepository controlMetrosKilosProductoRepository;
	
	@Override
	public ControlMetrosKilosProducto findById(Integer id) throws ObjectNotFoundException {
		return  controlMetrosKilosProductoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<ControlMetrosKilosProducto> findAll() {
		return controlMetrosKilosProductoRepository.findAll();
	}
	
	@Override
	@Transactional()
	public ControlMetrosKilosProducto save(ControlMetrosKilosProducto controlMetrosKilosProducto) {
		return controlMetrosKilosProductoRepository.save(controlMetrosKilosProducto);
	}
	
	@Override
	@Transactional()
	public List<ControlMetrosKilosProducto> saveAll(List<ControlMetrosKilosProducto> listTpoCambio) {
		return controlMetrosKilosProductoRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		ControlMetrosKilosProducto controlMetrosKilosProducto =  controlMetrosKilosProductoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		controlMetrosKilosProductoRepository.delete(controlMetrosKilosProducto);
	}
}
