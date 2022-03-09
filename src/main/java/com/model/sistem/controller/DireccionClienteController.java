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

import com.model.sistem.dto.DireccionClienteDTO;
import com.model.sistem.entities.DireccionCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.DireccionClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/direccionCliente")
public class DireccionClienteController  extends GenericMapper<DireccionCliente, DireccionClienteDTO> {

	@Autowired
	private DireccionClienteService direccionDireccionClienteService;

	
	@ApiOperation(value = "Dar de alta a los direccionDireccionClientes", notes = "Guardar campos necesarios del direccionDireccionCliente")
	@PostMapping("/")
	public ResponseEntity<DireccionClienteDTO> save(@Valid @RequestBody DireccionClienteDTO direccionDireccionClienteDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(direccionDireccionClienteService.save(toEntity(direccionDireccionClienteDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all clients")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DireccionClienteDTO>> findAll() {
	        List<DireccionCliente> list = direccionDireccionClienteService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DireccionClienteDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(direccionDireccionClienteService.findById(id)));
    }


    @ApiOperation(value = "Delete a Nego movement by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        direccionDireccionClienteService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}
