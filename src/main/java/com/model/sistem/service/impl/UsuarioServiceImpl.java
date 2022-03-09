package com.model.sistem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.sistem.entities.Usuario;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.repository.UsuarioRepository;
import com.model.sistem.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByNick(String nick){
		return usuarioRepository.findByNick(nick);
	}
	
	@Override
	public Usuario findById(Integer id) throws ObjectNotFoundException {
		return  usuarioRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
	}
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	@Transactional()
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	@Transactional()
	public List<Usuario> saveAll(List<Usuario> listTpoCambio) {
		return usuarioRepository.saveAll(listTpoCambio);
	}
	
	@Override
	@Transactional()
	public void delete(Integer id) throws ObjectNotFoundException {
		Usuario usuario =  usuarioRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("No se encontro registro con ese id "+id));
		usuarioRepository.delete(usuario);
	}
}
