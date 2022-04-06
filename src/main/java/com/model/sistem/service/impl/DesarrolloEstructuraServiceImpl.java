package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.DesarrolloEstructura;
import com.model.sistem.enums.EstadoEnum;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.DesarrolloEstructuraRepository;
import com.model.sistem.service.DesarrolloEstructuraService;

@Service
public class DesarrolloEstructuraServiceImpl implements DesarrolloEstructuraService{
	
	@Autowired
	private DesarrolloEstructuraRepository desarrolloEstructuraRepository;
	
	@Override
	public DesarrolloEstructura findById(Integer id) throws ObjectNotFoundException {
		return  desarrolloEstructuraRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<DesarrolloEstructura> findAll() {
		return desarrolloEstructuraRepository.findByEstado(EstadoEnum.ACTIVO.getEstado());
	}
	
	@Override
	@Transactional()
	public DesarrolloEstructura save(DesarrolloEstructura desarrolloEstructura) {
		return desarrolloEstructuraRepository.save(desarrolloEstructura);
	}
	
	@Override
	@Transactional()
	public List<DesarrolloEstructura> saveAll(List<DesarrolloEstructura> listTpoCambio) {
		return desarrolloEstructuraRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		DesarrolloEstructura desarrolloEstructura =  desarrolloEstructuraRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		desarrolloEstructuraRepository.delete(desarrolloEstructura);
	}
}
