package com.model.sistem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.sistem.dto.UsuarioDTO;
import com.model.sistem.entities.Usuario;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/usuario")
public class UsuarioController extends GenericMapper<Usuario, UsuarioDTO>  {

	@Autowired
	private UsuarioService usuarioService;

	
	@ApiOperation(value = "Dar de alta a los usuarios", notes = "Guardar campos necesarios del usuario")
	@PostMapping("/")
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuarioDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(usuarioService.save(toEntity(usuarioDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all Usuarios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
	        List<Usuario> list = usuarioService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get Usuario by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(usuarioService.findById(id)));
    }


    @ApiOperation(value = "Delete a Usuario by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        usuarioService.delete(id);
		return ResponseEntity.ok().build();

    }

}
