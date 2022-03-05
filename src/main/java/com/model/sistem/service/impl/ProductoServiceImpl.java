package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Producto;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.ProductoRepository;
import com.model.sistem.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto findById(String id) throws ObjectNotFoundException {
		return  productoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	
	@Override
	@Transactional()
	public List<Producto> saveAll(List<Producto> listTpoCambio) {
		return productoRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(String id) throws ObjectNotFoundException {
		Producto producto =  productoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		productoRepository.delete(producto);
	}
}
