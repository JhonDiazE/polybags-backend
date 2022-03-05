package com.model.sistem.service;

import com.model.sistem.entities.Usuario;

public interface UsuarioService {
	
	Usuario findByNick(String nick);
}
