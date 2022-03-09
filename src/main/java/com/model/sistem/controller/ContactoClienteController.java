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

import com.model.sistem.dto.ContactoClienteDTO;
import com.model.sistem.entities.ContactoCliente;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ContactoClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/contactoCliente")
public class ContactoClienteController  extends GenericMapper<ContactoCliente, ContactoClienteDTO> {

	@Autowired
	private ContactoClienteService contactoContactoClienteService;

	
	@ApiOperation(value = "Dar de alta a los contactoContactoClientes", notes = "Guardar campos necesarios del contactoContactoCliente")
	@PostMapping("/")
	public ResponseEntity<ContactoClienteDTO> save(@Valid @RequestBody ContactoClienteDTO contactoContactoClienteDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(contactoContactoClienteService.save(toEntity(contactoContactoClienteDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all Contacto")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ContactoClienteDTO>> findAll() {
	        List<ContactoCliente> list = contactoContactoClienteService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get client by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactoClienteDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(contactoContactoClienteService.findById(id)));
    }


    @ApiOperation(value = "Delete a Contacto by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        contactoContactoClienteService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}
