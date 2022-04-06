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

import com.model.sistem.dto.ControlMetrosKilosProductoDTO;
import com.model.sistem.entities.ControlMetrosKilosProducto;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.ControlMetrosKilosProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/controlMetrosKilosProducto")
public class ControlMetrosKilosProductoController  extends GenericMapper<ControlMetrosKilosProducto, ControlMetrosKilosProductoDTO> {

	@Autowired
	private ControlMetrosKilosProductoService controlMetrosKilosProductoService;

	
	@ApiOperation(value = "Dar de alta a los controlMetrosKilosProductos", notes = "Guardar campos necesarios del controlMetrosKilosProducto")
	@PostMapping("/")
	public ResponseEntity<ControlMetrosKilosProductoDTO> save(@Valid @RequestBody ControlMetrosKilosProductoDTO controlMetrosKilosProductoDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(controlMetrosKilosProductoService.save(toEntity(controlMetrosKilosProductoDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all ControlMetrosKilosProductos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ControlMetrosKilosProductoDTO>> findAll() {
	        List<ControlMetrosKilosProducto> list = controlMetrosKilosProductoService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get ControlMetrosKilosProducto by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControlMetrosKilosProductoDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(controlMetrosKilosProductoService.findById(id)));
    }


    @ApiOperation(value = "Delete a ControlMetrosKilosProducto by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        controlMetrosKilosProductoService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}
