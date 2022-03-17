package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Categoria;
import com.model.sistem.entities.Linea;
import com.model.sistem.enums.EstadoEnum;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.CategoriaRepository;
import com.model.sistem.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria findById(Integer id) throws ObjectNotFoundException {
		return  categoriaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	@Override
	public List<Categoria> findByEstadoAndLinea(Linea linea) {
		return categoriaRepository.findByEstadoAndLinea(EstadoEnum.ACTIVO.getEstado(), linea);
	}
	
	@Override
	@Transactional()
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Override
	@Transactional()
	public List<Categoria> saveAll(List<Categoria> listTpoCambio) {
		return categoriaRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Categoria categoria =  categoriaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		categoriaRepository.delete(categoria);
	}
}
