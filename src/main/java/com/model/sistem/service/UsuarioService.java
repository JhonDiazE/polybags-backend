package com.model.sistem.service;

import java.util.List;

import com.model.sistem.entities.Usuario;
import com.model.sistem.exceptions.ObjectNotFoundException;

public interface UsuarioService {
	
	Usuario findByNick(String nick);
	Usuario findById(Integer id) throws ObjectNotFoundException;
	List<Usuario> findAll();
	Usuario save(Usuario cliente) ;
	List<Usuario> saveAll(List<Usuario> cliente) ;
	void delete(Integer id) throws ObjectNotFoundException;
}
