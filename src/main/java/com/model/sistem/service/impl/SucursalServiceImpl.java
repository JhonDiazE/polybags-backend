package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Sucursal;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.SucursalRepository;
import com.model.sistem.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Override
	public Sucursal findById(Integer id) throws ObjectNotFoundException {
		return  sucursalRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Sucursal> findAll() {
		return sucursalRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Sucursal save(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}
	
	@Override
	@Transactional()
	public List<Sucursal> saveAll(List<Sucursal> listTpoCambio) {
		return sucursalRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Sucursal sucursal =  sucursalRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		sucursalRepository.delete(sucursal);
	}
}
