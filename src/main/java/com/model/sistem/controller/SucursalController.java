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

import com.model.sistem.dto.SucursalDTO;
import com.model.sistem.entities.Sucursal;
import com.model.sistem.exceptions.ObjectNotFoundException;
import com.model.sistem.service.SucursalService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping(value="/sucursal")
public class SucursalController  extends GenericMapper<Sucursal, SucursalDTO> {

	@Autowired
	private SucursalService sucursalService;

	
	@ApiOperation(value = "Dar de alta a los sucursals", notes = "Guardar campos necesarios del sucursal")
	@PostMapping("/")
	public ResponseEntity<SucursalDTO> save(@Valid @RequestBody SucursalDTO sucursalDTO, BindingResult result) {
		 if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        return new ResponseEntity<>(toDTO(sucursalService.save(toEntity(sucursalDTO))), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get all Sucursals")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SucursalDTO>> findAll() {
	        List<Sucursal> list = sucursalService.findAll();
	        if(CollectionUtils.isEmpty(list))
	        	return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(toDTOList(list));
	}

	
	@ApiOperation(value = "Get Sucursal by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SucursalDTO> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(toDTO(sucursalService.findById(id)));
    }


    @ApiOperation(value = "Delete a Sucursal by id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ObjectNotFoundException{
        sucursalService.delete(id);
		return ResponseEntity.ok().build();

    }

	
}
