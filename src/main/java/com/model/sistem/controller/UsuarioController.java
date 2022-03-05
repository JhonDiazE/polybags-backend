package com.model.sistem.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.sistem.dto.UsuarioDTO;
import com.model.sistem.entities.Usuario;
import com.model.sistem.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Buscar por Identificador: Usuario", notes = "Buscar un usuario existente en la base de datos")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
		Usuario u = usuarioService.findByNick("jhon");
		UsuarioDTO usuario = new UsuarioDTO();
		BeanUtils.copyProperties(u, usuario);
		return ResponseEntity.ok(usuario);
	}
}
