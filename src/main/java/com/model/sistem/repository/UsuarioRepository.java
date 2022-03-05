package com.model.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.sistem.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByNick(String nick);
}
