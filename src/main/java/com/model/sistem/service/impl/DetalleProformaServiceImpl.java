package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.DetalleProforma;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.DetalleProformaRepository;
import com.model.sistem.service.DetalleProformaService;

@Service
public class DetalleProformaServiceImpl implements DetalleProformaService{
	
	@Autowired
	private DetalleProformaRepository detalleProformaRepository;
	
	@Override
	public DetalleProforma findById(Long id) throws ObjectNotFoundException {
		return  detalleProformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<DetalleProforma> findAll() {
		return detalleProformaRepository.findAll();
	}
	
	@Override
	@Transactional()
	public DetalleProforma save(DetalleProforma detalleProforma) {
		return detalleProformaRepository.save(detalleProforma);
	}
	
	@Override
	@Transactional()
	public List<DetalleProforma> saveAll(List<DetalleProforma> listTpoCambio) {
		return detalleProformaRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Long id) throws ObjectNotFoundException {
		DetalleProforma detalleProforma =  detalleProformaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		detalleProformaRepository.delete(detalleProforma);
	}
}
