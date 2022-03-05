package com.model.sistem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.sistem.entities.Usuario;
import com.model.sistem.repository.UsuarioRepository;
import com.model.sistem.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByNick(String nick){
		return usuarioRepository.findByNick(nick);
	}
}
